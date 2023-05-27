/*
 * @lc app=leetcode.cn id=2451 lang=java
 * 
 * @lcpr version=21908
 *
 * [2451] 差值数组不同的字符串
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayDeque;
// @lc code=start


class Solution {
    public String oddString(String[] words) {
        Map<String, int[]> map = new HashMap<>();
        boolean flag = false;
        for (int i = 0; i < words.length; i++) {
            char[] chs = words[i].toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < chs.length; j++) {
                sb.append((char) (chs[j] - chs[j - 1]));
            }
            // System.out.println(Arrays.toString(arr));
            if (map.containsKey(sb.toString())) {
                int[] arr = map.get(sb.toString());
                map.put(sb.toString(), new int[] {arr[0] + 1, i});
            } else {
                int[] arr = new int[] {1, i};
                map.put(sb.toString(), arr);
            }

        }

        long count = Arrays.stream(words).map(e -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < e.length(); i++) {
                sb.append((char) e.charAt(i) - e.charAt(i - 1));
            }
            return sb.toString();
        }).distinct().count();
        System.out.println(count);
        for (var val : map.entrySet()) {
            if (val.getValue()[0] == 1) {
                return words[val.getValue()[1]];
            }
        }
        return null;
    }

}
// @lc code=end



/*
// @lcpr case=start
// ["adc","wzy","abc"]\n
// @lcpr case=end

// @lcpr case=start
// ["aaa","bob","ccc","ddd"]\n
// @lcpr case=end

 */

