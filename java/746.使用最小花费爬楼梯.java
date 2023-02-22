/*
 * @lc app=leetcode.cn id=746 lang=java
 * 
 * @lcpr version=21704
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // int n = cost.length;
        // int[] dp = new int[n];
        // dp[0] = cost[0];
        // dp[1] = cost[1];
        // for (int i = 2; i < n; i++) {
        // dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        // }
        // return Math.min(dp[n - 1], dp[n - 2]);


        int n = cost.length;
        int[] dp = new int[2];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            int sum = Math.min(dp[0], dp[1]) + cost[i];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return Math.min(dp[0], dp[1]);
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // [10,15,20]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1,100,1,1,1,100,1,1,100,1]\n // @lcpr case=end
 * 
 */


