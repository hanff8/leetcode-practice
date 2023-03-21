/*
 * @lc app=leetcode.cn id=2389 lang=java
 * 
 * @lcpr version=21801
 *
 * [2389] 和有限的最长子序列
 */

// @lc code=start
class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length, m = queries.length;
        Arrays.sort(nums);
        int[] f = new int[n + 1];
        for (int i = 0; i < n; i++) {
            f[i + 1] = f[i] + nums[i];
        }
        int[] answer = new int[m];
        for (int i = 0; i < m; i++) {
            answer[i] = binarySearch(f, queries[i]) - 1;
        }
        return answer;
    }

    public int binarySearch(int[] f, int target) {
        int low = 1, high = f.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (f[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // [4,5,2,1]\n[3,10,21]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [2,3,4,5]\n[1]\n // @lcpr case=end
 * 
 */


