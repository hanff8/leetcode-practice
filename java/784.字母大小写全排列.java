/*
 * @lc app=leetcode.cn id=784 lang=java
 * 
 * @lcpr version=21907
 *
 * [784] 字母大小写全排列
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

// @lc code=start
class Solution {
    public void dfs(List<String> res, String s, char[] chs, int index) {
        if (index == chs.length) {
            res.add(new String(chs));
            return;
        }
        // 不转换
        dfs(res, s, chs, index + 1);

        // 转换
        if (Character.isLetter(chs[index])) {
            // 大小写转换
            chs[index] ^= (1 << 5);
            dfs(res, s, chs, index + 1);
        }


    }

    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        dfs(res, s, s.toCharArray(), 0);
        // Collections.sort(res, (a, b) -> b.compareTo(a));
        return res;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // "a1b2"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "3z4"\n // @lcpr case=end
 * 
 */

