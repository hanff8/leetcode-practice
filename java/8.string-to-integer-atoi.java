/*
 * @lc app=leetcode.cn id=8 lang=java
 * 
 * @lcpr version=21917
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
	public int myAtoi(String s) {
		int res = 0;
		int n = s.length();
		if (n == 0)
			return 0;
		char[] chs = s.toCharArray();
		boolean isPositive = true;
		int index = 0;
		while (index < n && chs[index] == ' ')
			index++;

		if (index < n && (chs[index] == '-' || chs[index] == '+')) {
			isPositive = chs[index] == '-' ? false : true;
			index++;
		}

		while (index < n && Character.isDigit(chs[index])) {
			int digit = chs[index] - '0';
			if (res > (Integer.MAX_VALUE - digit) / 10) {
				return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			res = res * 10 + digit;
			++index;
		}
		return isPositive ? res : -res;

	}
}
// @lc code=end



/*
// @lcpr case=start
// "42"\n
// @lcpr case=end

// @lcpr case=start
// "   -42"\n
// @lcpr case=end

// @lcpr case=start
// "4193 with words"\n
// @lcpr case=end

 */

