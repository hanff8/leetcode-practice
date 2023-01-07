/*
 * @lc app=leetcode.cn id=2185 lang=java
 * @lcpr version=21105
 *
 * [2185] 统计包含给定前缀的字符串
 */

// @lc code=start
class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String string : words) {
            if (string.startsWith(pref))
                ++count;
        }
        return count;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // ["pay","attention","practice","attend"]\n"at"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // ["leetcode","win","loops","success"]\n"code"\n
 * // @lcpr case=end
 * 
 */
