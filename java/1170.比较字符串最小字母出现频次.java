/*
 * @lc app=leetcode.cn id=1170 lang=java
 * 
 * @lcpr version=21909
 *
 * [1170] 比较字符串最小字母出现频次
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeMap;
import java.util.ArrayDeque;

// @lc code=start
class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int n = queries.length;
        int m = words.length;
        TreeMap<Character, Integer> map = new TreeMap<>();
        int[] arr_q = new int[n];
        int[] arr_w = new int[m];
        for (int i = 0; i < n; ++i) {
            char[] chs = queries[i].toCharArray();
            for (int j = 0; j < chs.length; j++) {
                map.put(chs[j], map.getOrDefault(chs[j], 0) + 1);
            }
            arr_q[i] = map.firstEntry().getValue();
            map.clear();
        }

        for (int i = 0; i < m; i++) {
            char[] chs = words[i].toCharArray();
            for (int j = 0; j < chs.length; j++) {
                map.put(chs[j], map.getOrDefault(chs[j], 0) + 1);
            }
            arr_w[i] = map.firstEntry().getValue();
            map.clear();
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr_q[i] < arr_w[j]) {
                    res[i]++;
                }
            }
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// ["cbd"]\n["zaaaz"]\n
// @lcpr case=end

// @lcpr case=start
// ["bbb","cc"]\n["a","aa","aaa","aaaa"]\n
// @lcpr case=end

 */

