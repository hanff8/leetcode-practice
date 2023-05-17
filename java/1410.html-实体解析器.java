/*
 * @lc app=leetcode.cn id=1410 lang=java
 * 
 * @lcpr version=21907
 *
 * [1410] HTML 实体解析器
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Deque;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
// @lc code=start


class Solution {
    public String entityParser(String text) {
        // return text.replaceAll("\\&quot;", "\"").replaceAll("\\&apos;", "'")
        // .replaceAll("\\&gt;", ">").replaceAll("\\&lt;", "<").replaceAll("\\&frasl;", "/")
        // .replaceAll("\\&amp;", "&");

        Map<String, String> map = new HashMap<>() {
            {
                put("&quot;", "\"");
                put("&apos;", "'");
                put("&amp;", "&");
                put("&gt;", ">");
                put("&lt;", "<");
                put("&frasl;", "/");
            }
        };
        // Deque<Character> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (var ch : text.toCharArray()) {
            if (ch == '&') {
                if (sb.length() != 0) {
                    res.append(sb.toString());
                    sb.setLength(0);
                }
                sb.append(ch);
            } else if (ch != ';') {
                sb.append(ch);
            } else {
                sb.append(ch);
                res.append(map.getOrDefault(sb.toString(), sb.toString()));
                sb.setLength(0);
            }
        }
        return res.toString() + sb.toString();
    }
}
// @lc code=end



/*
 * // @lcpr case=start // "& is an HTML entity but &ambassador; is not."\n // @lcpr case=end
 * 
 * // @lcpr case=start // "and I quote: "...""\n // @lcpr case=end
 * 
 * // @lcpr case=start // "Stay home! Practice on Leetcode :)"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "x > y && x < y is always false"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "leetcode.com⁄problemset⁄all"\n // @lcpr case=end
 * 
 */

