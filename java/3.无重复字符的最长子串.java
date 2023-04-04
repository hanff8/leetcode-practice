import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 * 
 * @lcpr version=21901
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            Set<Character> set = new HashSet<>();
            int j = 0;
            for (j = i; j < n; j++) {
                if (set.contains(s.charAt(j)))
                    break;
                set.add(s.charAt(j));
            }
            ans = Math.max(ans, j - i);
        }
        return ans;
        // int[] a = new int[2];
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int ans = 0;
        int rk = -1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i != 0)
                set.remove(s.charAt(i - 1));
            while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) {
                set.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < n; end++) {
            char c = s.charAt(end);
            // 遇到重复出现的字符
            if (map.containsKey(c)) {
                start = Math.max(map.get(c), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }
}
// @lc code=end

/*
 * // @lcpr case=start // "abcabcbb"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "bbbbb"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "pwwkew"\n // @lcpr case=end
 * 
 */
