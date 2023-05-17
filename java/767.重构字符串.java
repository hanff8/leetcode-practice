/*
 * @lc app=leetcode.cn id=767 lang=java
 * 
 * @lcpr version=21907
 *
 * [767] 重构字符串
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;

// @lc code=start
class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (var ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        char[] chs = new char[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (var entry : map.entrySet()) {
            pq.offer(new int[] {entry.getKey(), entry.getValue()});
        }
        for (int i = 0; i < n; i++) {
            int[] p = pq.poll();
            int key = p[0], val = p[1];
            if (i == 0 || chs[i - 1] != key) {
                chs[i] = (char) key;

                pq.offer(new int[] {key, --val});
            } else {
                if (pq.size() == 0)
                    return "";
                int[] p1 = pq.poll();
                int key1 = p1[0], val1 = p1[1];
                chs[i] = (char) key1;
                if (val1 > 1)
                    pq.offer(new int[] {key1, --val1});
                pq.offer(new int[] {key, val});
            }
        }
        return String.valueOf(chs);
    }
}
// @lc code=end



/*
 * // @lcpr case=start // "aab"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "aaab"\n // @lcpr case=end
 * 
 */

