/*
 * @lc app=leetcode.cn id=1003 lang=java
 * 
 * @lcpr version=21907
 *
 * [1003] 检查替换后的词是否有效
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public boolean isValid(String S) {
        // 字符串解析
        // for (int i = 0; i < s.length() - 2; ++i) {
        // if (s.substring(i, i + 3).equals("abc")) {
        // s = s.substring(0, i) + s.substring(i + 3);
        // i = -1;
        // }
        // }
        // return s.equals("");

        // 栈
        // StringBuilder sb = new StringBuilder();
        // for (char ch : s.toCharArray()) {
        // sb.append(ch);
        // if (sb.length() >= 3 && sb.substring(sb.length() - 3, sb.length()).equals("abc")) {
        // sb.delete(sb.length() - 3, sb.length());
        // }
        // }
        // return sb.length() == 0;

        var s = S.toCharArray(); // 同时作为栈
        int i = 0; // i-1 表示栈顶下标，i=0 表示栈为空
        for (var c : s) {
            // 如果为字符 'c',且上一个字符为'b',i直接减去二,表示将栈中的a,b弹出，表示匹配到一个"abc"
            if (c > 'a' && (i == 0 || c - s[--i] != 1))
                return false;
            if (c < 'c')
                s[i++] = c; // 入栈
        }
        return i == 0;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // "aabcbc"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "abcabcababcc"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "abccba"\n // @lcpr case=end
 * 
 */

