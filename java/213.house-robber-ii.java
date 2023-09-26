/*
 * @lc app=leetcode.cn id=213 lang=java
 * 
 * @lcpr version=21913
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
	public int rob(int[] nums) {
		int n = nums.length;
		return Math.max(nums[0] + rob1(nums, 2, n - 1), rob1(nums, 1, n));
	}

	private int rob1(int[] nums, int i, int j) {
		int f1 = 0, f2 = 0;
		for (int k = i; k < j; k++) {
			int newf = Math.max(f2, f1 + nums[k]);
			f1 = f2;
			f2 = newf;
		}
		return f2;
	}
}
// @lc code=end



/*
// @lcpr case=start
// [2,3,2]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

 */

