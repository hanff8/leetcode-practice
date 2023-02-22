/*
 * @lc app=leetcode.cn id=343 lang=java
 * 
 * @lcpr version=21704
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                int temp = Math.max(j * (i - j), j * dp[i - j]);
                dp[i] = Math.max(temp, dp[i]);
            }
        }
        return dp[n];
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // 2\n // @lcpr case=end
 * 
 * // @lcpr case=start // 10\n // @lcpr case=end
 * 
 */


