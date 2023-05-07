/*
 * @lc app=leetcode.cn id=1957 lang=java
 * 
 * @lcpr version=21907
 *
 * [1957] 删除字符使字符串变好
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
// @lc code=start

// import java.util.ArrayList;

class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int size = sb.length();
            if (size >= 2 && sb.charAt(size - 1) == sb.charAt(size - 2)
                    && sb.charAt(size - 1) == s.charAt(i)) {
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
// @lc code=end



/*
 * // @lcpr case=start // "leeetcode"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "aaabaaaa"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "aab"\n // @lcpr case=end
 * 
 */

