/*
 * @lc app=leetcode.cn id=2437 lang=java
 * 
 * @lcpr version=21907
 *
 * [2437] 有效时间的数目
 */

// @lc code=start
class Solution {
    public int countTime(String time) {
        int ans = 1;

        if (time.charAt(0) == '?' && time.charAt(1) == '?') {
            ans *= 24;
        }
        if (time.charAt(0) == '?' && time.charAt(1) != '?') {
            int a = time.charAt(1) - '0';
            System.out.println(a);
            if (a < 4)
                ans *= 3;
            else
                ans *= 2;
        }
        if (time.charAt(0) != '?' && time.charAt(1) == '?') {
            int a = time.charAt(0) - '0';
            if (a == 2)
                ans *= 4;
            else
                ans *= 10;
        }
        if (time.charAt(3) == '?')
            ans *= 6;
        if (time.charAt(4) == '?')
            ans *= 10;
        return ans;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // "?5:00"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "0?:0?"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "??:??"\n // @lcpr case=end
 * 
 */

