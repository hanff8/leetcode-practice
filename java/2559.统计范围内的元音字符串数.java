/*
 * @lc app=leetcode.cn id=2559 lang=java
 * 
 * @lcpr version=21908
 *
 * [2559] 统计范围内的元音字符串数
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
    // public int[] vowelStrings(String[] words, int[][] queries) {
    //     int[] map = new int['z' + 1];
    //     map['a'] = 1;
    //     map['e'] = 1;
    //     map['i'] = 1;
    //     map['o'] = 1;
    //     map['u'] = 1;
    //     int[] res = new int[queries.length];
    //     int[] cache = new int[words.length + 1];
    //     for (int j = 0; j < words.length; j++) {
    //         String str = words[j];
    //         if (map[str.charAt(0)] == 1 && map[str.charAt(str.length() - 1)] == 1) {
    //             cache[j + 1] = cache[j] + 1;
    //         } else {
    //             cache[j + 1] = cache[j];
    //         }
    //     }
    //     for (int i = 0; i < queries.length; i++) {
    //         res[i] = cache[queries[i][1] + 1] - cache[queries[i][0]];
    //     }
    //     return res;
    // }


    //二分
    List<Integer> list = new ArrayList<>();

    public int lower_bound(int x) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] map = new int['z' + 1];
        map['a'] = 1;
        map['e'] = 1;
        map['i'] = 1;
        map['o'] = 1;
        map['u'] = 1;

        for (int i = 0; i < words.length; ++i) {
            if (map[words[i].charAt(0)] == 1 && map[words[i].charAt(words[i].length() - 1)] == 1) {
                list.add(i);
            }
        }
        int i = 0;
        int[] res = new int[queries.length];
        for (var q : queries) {
            int left = q[0], right = q[1];
            //[left,right+1)
            res[i++] = lower_bound(right + 1) - lower_bound(left);
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// ["aba","bcb","ece","aa","e"]\n[[0,2],[1,4],[1,1]]\n
// @lcpr case=end

// @lcpr case=start
// ["a","e","i"]\n[[0,2],[0,1],[2,2]]\n
// @lcpr case=end

 */

