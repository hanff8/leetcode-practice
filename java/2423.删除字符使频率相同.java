/*
 * @lc app=leetcode.cn id=2423 lang=java
 * 
 * @lcpr version=21907
 *
 * [2423] 删除字符使频率相同
 */

// @lc code=start

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean equalFrequency(String word) {
        int n = word.length();
        for (int i = 0; i < n; ++i) {
            Map<Character, Integer> map = new HashMap<>();
            String s = word.subSequence(0, i) + word.substring(i + 1);
            for (var ch : s.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            if (isSame(map)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSame(Map<Character, Integer> map) {
        int c0 = map.entrySet().iterator().next().getValue();
        for (var val : map.values()) {
            if (c0 != val) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // "abcc"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "aazz"\n // @lcpr case=end
 * 
 */

