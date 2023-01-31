/*
 * @lc app=leetcode.cn id=10 lang=java
 * @lcpr version=21202
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            if (s.charAt(i) != p.charAt(i)) {
                if (p.charAt(j) == '.' || p.charAt(j) == '*') {

                } else
                    return false;
            }
            ++i;
            ++j;
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "aa"\n"a"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "aa"\n"a*"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "ab"\n".*"\n
 * // @lcpr case=end
 * 
 */
