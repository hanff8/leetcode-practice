/*
 * @lc app=leetcode.cn id=1156 lang=java
 * 
 * @lcpr version=21908
 *
 * [1156] 单字符重复子串的最大长度
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

    public int maxRepOpt1(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        for (int i = 0; i < text.length();) {
            int j = i;
            while (j < text.length() && text.charAt(j) == text.charAt(i)) {
                j++;
            }
            int curCnt = j - i;//[i,j)


            if (curCnt < map.getOrDefault(text.charAt(i), 0) && (j < text.length() || i > 0)) {
                res = Math.max(res, curCnt + 1);
            }


            int k = j + 1;
            while (k < text.length() && text.charAt(k) == text.charAt(i)) {
                k++;
            }
            res = Math.max(res, Math.min(k - 1, map.getOrDefault(text.charAt(i), 0)));
            i = j;
        }
        return res;

    }
}
// @lc code=end



/*
// @lcpr case=start
// "ababa"\n
// @lcpr case=end

// @lcpr case=start
// "aaabaaa"\n
// @lcpr case=end

// @lcpr case=start
// "aaabbaaa"\n
// @lcpr case=end

// @lcpr case=start
// "aaaaa"\n
// @lcpr case=end

// @lcpr case=start
// "abcdef"\n
// @lcpr case=end

 */

