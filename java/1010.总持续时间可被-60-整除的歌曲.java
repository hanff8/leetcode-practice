/*
 * @lc app=leetcode.cn id=1010 lang=java
 * 
 * @lcpr version=21907
 *
 * [1010] 总持续时间可被 60 整除的歌曲
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
    public int numPairsDivisibleBy60(int[] time) {
        int[] record = new int[60];
        int ans = 0;
        // i , j可以重复组合即（1,4）(1,3)都是符合要求的答案
        // for (int t : time) {
        // t %= 60;
        // if (t != 0) {
        // count += record[60 - t];
        // } else
        // count += record[t];
        // record[t]++;
        // }
        for (int i = 0; i < time.length; i++) {
            ans += record[(60 - time[i] % 60) % 60];
            record[time[i] % 60]++;
        }
        return ans;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // [30,20,150,100,40]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [60,60,60]\n // @lcpr case=end
 * 
 */

