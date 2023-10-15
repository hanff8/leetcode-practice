/*
 * @lc app=leetcode.cn id=123 lang=java
 * 
 * @lcpr version=21917
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[][] dp = new int[n][2];
		dp[0][0] = 0;
		dp[0][1] = -prices[0];

	}
}
// @lc code=end



/*
// @lcpr case=start
// [3,3,5,0,0,3,1,4]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,5]\n
// @lcpr case=end

// @lcpr case=start
// [7,6,4,3,1]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

