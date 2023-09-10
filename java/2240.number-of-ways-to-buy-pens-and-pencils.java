/*
 * @lc app=leetcode.cn id=2240 lang=java
 * 
 * @lcpr version=21913
 *
 * [2240] 买钢笔和铅笔的方案数
 */

// @lc code=start
class Solution {
	public long waysToBuyPensPencils(int total, int cost1, int cost2) {
		if (cost1 < cost2) {
			return waysToBuyPensPencils(total, cost2, cost1);
		}
		long res = 0, cnt = 0;
		while (cnt * cost1 <= total) {
			res += (total - cnt * cost1) / cost2 + 1;
			cnt++;
		}
		return res;
	}
}
// @lc code=end



/*
// @lcpr case=start
// 20\n10\n5\n
// @lcpr case=end

// @lcpr case=start
// 5\n10\n10\n
// @lcpr case=end

 */

