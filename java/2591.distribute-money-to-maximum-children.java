/*
 * @lc app=leetcode.cn id=2591 lang=java
 * 
 * @lcpr version=21914
 *
 * [2591] 将钱分给最多的儿童
 */

// @lc code=start
class Solution {
	public int distMoney(int money, int children) {
		if (money < children)
			return -1;
		money -= children;
		int cnt = Math.min(money / 7, children);
		money -= cnt * 7;
		children -= cnt;
		if ((children == 0 && money > 0) || (children == 1 && money == 3)) {
			cnt--;
		}
		return cnt;
	}
}
// @lc code=end



/*
// @lcpr case=start
// 20\n3\n
// @lcpr case=end

// @lcpr case=start
// 16\n2\n
// @lcpr case=end

 */

