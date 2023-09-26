/*
 * @lc app=leetcode.cn id=LCP 06 lang=java
 * 
 * @lcpr version=21914
 *
 * [LCP 06] 拿硬币
 */

// @lc code=start
class Solution {
	public int minCount(int[] coins) {
		int res = 0;
		for (int v : coins) {
			if (v % 2 == 0) {
				res += v / 2;
			} else {
				res += (v + 1) / 2;
			}
		}
		return res;
	}
}
// @lc code=end



/*
// @lcpr case=start
// [4,2,1]\n
// @lcpr case=end

// @lcpr case=start
// [2,3,10]\n
// @lcpr case=end

 */

