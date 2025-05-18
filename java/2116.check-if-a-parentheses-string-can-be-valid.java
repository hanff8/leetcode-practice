/*
 * @lc app=leetcode.cn id=2116 lang=java
 * 
 * @lcpr version=30204
 *
 * [2116] 判断一个括号字符串是否有效
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
	char LEFT_BRACKET = '(';
	char RIGHT_BRACKET = ')';

	public boolean canBeValid(String s, String locked) {
		if (s.length() % 2 != 0)
			return false;
		char[] chs = s.toCharArray();
		char[] chs_locked = locked.toCharArray();
		int min = 0;
		int max = 0;
		int n = chs.length;

		for (int i = 0; i < n; i++) {
			if (chs_locked[i] == '0') {
				min--;
				max++;
				if (max < 0) {
					return false;
				}
				if (min < 0) {
					min = 1;
				}
			} else {
				if (chs[i] == LEFT_BRACKET) {
					min++;
					max++;
				} else {
					min--;
					max--;
					if (max < 0)
						return false;
					if (min < 0)
						min = 1;
				}
			}
		}
		return min == 0;
	}
}
// @lc code=end



/*
// @lcpr case=start
// "))()))"\n"010100"\n
// @lcpr case=end

// @lcpr case=start
// "()()"\n"0000"\n
// @lcpr case=end

// @lcpr case=start
// ")"\n"0"\n
// @lcpr case=end

// @lcpr case=start
// "(((())(((())"\n"111111010111"\n
// @lcpr case=end

 */

