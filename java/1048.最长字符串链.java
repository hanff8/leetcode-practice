import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1048 lang=java
 * 
 * @lcpr version=21907
 *
 * [1048] 最长字符串链
 */

// @lc code=start
class Solution {
    Map<String, Integer> map = new HashMap<>();

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        // for (var str : words) {
        // map.put(str, 0);
        // }
        int ans = 0;
        for (var s : words) {
            int res = 0;
            for (int i = 0; i < s.length(); ++i) {
                String t = s.substring(0, i) + s.substring(i + 1);
                res = Math.max(res, map.getOrDefault(t, 0));
            }

            map.put(s, res + 1);
            ans = Math.max(ans, res + 1);
        }
        return ans;
    }

    public int dfs(String s) {
        int res = map.get(s);
        if (res > 0)
            return res;
        for (int i = 0; i < s.length(); ++i) {
            var t = s.substring(0, i) + s.substring(i + 1);
            if (map.containsKey(t)) {
                res = Math.max(res, dfs(t));
            }
        }
        map.put(s, res + 1);// 记忆化
        return res + 1;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // ["a","b","ba","bca","bda","bdca"]\n // @lcpr case=end
 * 
 * // @lcpr case=start // ["xbc","pcxbcf","xb","cxbc","pcxbc"]\n // @lcpr case=end
 * 
 * // @lcpr case=start // ["abcd","dbqca"]\n // @lcpr case=end
 * 
 */

