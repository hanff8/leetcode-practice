/*
 * @lc app=leetcode.cn id=1844 lang=java
 * 
 * @lcpr version=21801
 *
 * [1844] 将所有数字用字符替换
 */

// @lc code=start
class Solution {
    public String replaceDigits(String s) {
        if (s.length() == 1)
            return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i += 2) {
            sb.append(s.charAt(i - 1));
            sb.append((char) (s.charAt(i) - '0' + s.charAt(i - 1)));
            if (i == s.length() - 2)
                sb.append(s.charAt(i + 1));

        }
        return sb.toString();
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // "a1c1e1"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "a1b2c3d4e"\n // @lcpr case=end
 * 
 */


