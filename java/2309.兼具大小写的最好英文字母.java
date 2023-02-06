import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2309 lang=java
 * @lcpr version=21108
 *
 * [2309] 兼具大小写的最好英文字母
 */

// @lc code=start
class Solution {
    public String greatestLetter(String s) {
        int[] low = new int[26];
        int[] up = new int[26];
        String res = "";
        Arrays.fill(low, 0);
        Arrays.fill(up, 0);
        for (int i = 0; i < s.length(); i++) {
            int pos;
            if (s.charAt(i) - 'a' >= 0) {
                pos = s.charAt(i) - 'a';
                low[pos]++;
            } else if (s.charAt(i) - 'A' >= 0) {
                pos = s.charAt(i) - 'A';
                up[pos]++;
            }

        }
        for (int i = 0; i < up.length; i++) {
            if (up[i] != 0 && low[i] != 0) {
                char temp = (char) (i + 'A');
                res = temp + "";
            }
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "lEeTcOdE"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "arRAzFif"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "AbCdEfGhIjK"\n
 * // @lcpr case=end
 * 
 */
