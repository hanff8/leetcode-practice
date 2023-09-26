/*
 * @lc app=leetcode.cn id=198 lang=java
 * 
 * @lcpr version=21913
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
	public int rob(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (n == 1) {
			return nums[0];
		}
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < n; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		return dp[n - 1];
	}
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,1]\n
// @lcpr case=end

// @lcpr case=start
// [2,7,9,3,1]\n
// @lcpr case=end

 */

