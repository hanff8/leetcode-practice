/*
 * @lc app=leetcode.cn id=1513 lang=java
 * 
 * @lcpr version=21907
 *
 * [1513] 仅含 1 的子串数
 */
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


    public int numSub(String s) {
        String[] arr = s.split("0");

        int res = 0;

        for (int i = 0; i < arr.length; ++i) {
            if (arr[i].equals(""))
                continue;
            res += ((long) (arr[i].length() + 1) * arr[i].length() / 2) % 1000000007;
        }
        return res;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // "0110111"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "101"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "111111"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "000"\n // @lcpr case=end
 * 
 */

