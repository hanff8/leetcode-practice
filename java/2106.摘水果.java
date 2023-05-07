/*
 * @lc app=leetcode.cn id=2106 lang=java
 * 
 * @lcpr version=21907
 *
 * [2106] 摘水果
 */

// @lc code=start
class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        // 能够摘取的说过的前缀和
        int[] preS = new int[n + 1];

        // 记录下标
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            preS[i + 1] = preS[i] + fruits[i][1];
            indices[i] = fruits[i][0];
        }

        int ans = 0;
        for (int x = 0; x <= k / 2; ++x) {
            // 向左走x步，再向右走k-x
            int y = k - 2 * x;
            int left = startPos - x;
            int right = startPos + y;
            int start = lowerBound(indices, 0, n - 1, left);
            int end = upperBound(indices, 0, n - 1, right);
            ans = Math.max(ans, preS[end] - preS[start]);

            // 向右走x步再向左走k-x步
            y = k - 2 * x;
            left = startPos - y;
            right = startPos + x;
            start = lowerBound(indices, 0, n - 1, left);
            end = upperBound(indices, 0, n - 1, right);
            ans = Math.max(ans, preS[end] - preS[start]);
        }
        return ans;

    }

    public int lowerBound(int[] arr, int left, int right, int val) {
        int res = right + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= val) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    public int upperBound(int[] arr, int left, int right, int val) {
        int res = right + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > val) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

}
// @lc code=end



/*
 * // @lcpr case=start // [[2,8],[6,3],[8,6]]\n5\n4\n // @lcpr case=end
 * 
 * // @lcpr case=start // [[0,9],[4,1],[5,7],[6,2],[7,4],[10,9]]\n5\n4\n // @lcpr case=end
 * 
 * // @lcpr case=start // [[0,3],[6,4],[8,5]]\n3\n2\n // @lcpr case=end
 * 
 */

