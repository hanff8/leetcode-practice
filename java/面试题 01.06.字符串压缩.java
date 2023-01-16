/*
 * @lc app=leetcode.cn id=面试题 01.06 lang=java
 * @lcpr version=21105
 *
 * [面试题 01.06] 字符串压缩
 */

// @lc code=start
class Solution {
    public String compressString(String S) {
        if (S.isEmpty() || S == null) {
            return S;
        }
        StringBuilder sb = new StringBuilder();
        char ch = S.charAt(0);
        int num = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == ch) {
                num++;
            } else {
                sb.append(ch);
                sb.append(num);
                ch = S.charAt(i);
                num = 1;
            }
        }
        sb.append(ch);
        sb.append(num);
        return sb.length() < S.length() ? sb.toString() : S;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * //
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * //
 * // @lcpr case=end
 * 
 */
