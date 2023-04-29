/*
 * @lc app=leetcode.cn id=1043 lang=java
 * 
 * @lcpr version=21906
 *
 * [1043] 分隔数组以得到最大和
 */

// @lc code=start
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int maxValue = arr[i - 1];
            for (int j = i - 1; j >= 0 && j >= i - k; j--) {
                d[i] = Math.max(d[i], d[j] + maxValue * (i - j));
                if (j > 0) {
                    maxValue = Math.max(maxValue, arr[j - 1]);
                }
            }
        }
        return d[n];
    }
}
// @lc code=end



/*
 * // @lcpr case=start // [1,15,7,9,2,5,10]\n3\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1,4,1,5,7,3,6,1,9,9,3]\n4\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1]\n1\n // @lcpr case=end
 * 
 */

