/*
 * @lc app=leetcode.cn id=868 lang=java
 * 
 * @lcpr version=21907
 *
 * [868] 二进制间距
 */

// @lc code=start
class Solution {
    public int binaryGap(int n) {
        // String a = Integer.toBinaryString(n);
        // int len = a.length();
        // int res = 0;
        // int lastOne = 0;
        // for (int i = 0; i < len; ++i) {
        // if (a.charAt(i) == '1') {
        // res = Math.max(res, i - lastOne);
        // lastOne = i;
        // }
        // }
        // return res;

        // lastOne记录上一个'1'的位置
        int lastOne = -1, i = 0;
        int ans = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                if (lastOne != -1) {
                    ans = Math.max(ans, i - lastOne);
                }
                lastOne = i;
            }
            n >>= 1;
            i++;
        }
        return ans;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // 22\n // @lcpr case=end
 * 
 * // @lcpr case=start // 8\n // @lcpr case=end
 * 
 * // @lcpr case=start // 5\n // @lcpr case=end
 * 
 */

