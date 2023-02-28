/*
 * @lc app=leetcode.cn id=70 lang=java
 * 
 * @lcpr version=21704
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[3];
        if (n == 1 || n == 2)
            return n;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int sum = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = sum;
        }
        return dp[2];
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
 * // @lcpr case=start // 3\n // @lcpr case=end
 * 
 */


