/*
 * @lc app=leetcode.cn id=2582 lang=java
 * 
 * @lcpr version=21917
 *
 * [2582] 递枕头
 */

// @lc code=start
class Solution {
	public int passThePillow(int n, int time) {
		int i = 1;
		boolean flag = false;
		while (time != 0) {
			if (i == 1) {
				flag = false;
			}
			if (i == n) {
				flag = true;
			}

			if (!flag)
				i++;
			else
				i--;
			time--;
		}
		return i;
	}
}
// @lc code=end



/*
// @lcpr case=start
// 4\n5\n
// @lcpr case=end

// @lcpr case=start
// 3\n2\n
// @lcpr case=end

 */

