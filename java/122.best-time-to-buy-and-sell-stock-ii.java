/*
 * @lc app=leetcode.cn id=122 lang=java
 * 
 * @lcpr version=21917
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
	public int maxProfit(int[] prices) {
		// return solution1(prices);
		// return solution2(prices);
		return solution3(prices);

	}

	private int solution3(int[] prices) {
		int n = prices.length;
		int[][] dp = new int[n][2];
		dp[0][0] = 0;
		dp[0][1] = -prices[0];
		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
		}
		return dp[n - 1][0];
	}

	// 买卖次数是没有限制的
	private int solution2(int[] prices) {
		int n = prices.length;
		int res = 0;

		for (int i = 1; i < n; i++) {
			res += Math.max(0, prices[i] - prices[i - 1]);
		}
		return res;

	}

	private int solution1(int[] prices) {
		int i = 0, j = 0;
		int n = prices.length;
		int ans = 0;
		while (i < n && j < n) {
			while (i + 1 < n && prices[i + 1] < prices[i])
				i++;

			j = i;
			while (j + 1 < n && prices[j + 1] > prices[j]) {
				j++;
			}
			ans += prices[j] - prices[i];
			j++;
			i = j;

		}
		return ans;
	}
}
// @lc code=end



/*
// @lcpr case=start
// [7,1,5,3,6,4]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,5]\n
// @lcpr case=end

// @lcpr case=start
// [7,6,4,3,1]\n
// @lcpr case=end

 */

