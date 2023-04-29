/*
 * @lc app=leetcode.cn id=1163 lang=java
 * 
 * @lcpr version=21907
 *
 * [1163] 按字典序排在最后的子串
 */

// @lc code=start
class Solution {
    public String lastSubstring(String s) {
        int n = s.length();
        int i = 0;
        for (int j = 1, k = 0; j + k < n;) {
            int d = s.charAt(i + k) - s.charAt(j + k);
            if (d == 0)
                ++k;
            else if (d < 0) {
                i += k + 1;
                k = 0;
                if (i >= j) {
                    j = i + 1;
                }
            } else {
                j += k + 1;
                k = 0;
            }
        }
        return s.substring(i);
    }
}
// @lc code=end



/*
 * // @lcpr case=start // "abab"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "leetcode"\n // @lcpr case=end
 * 
 */

