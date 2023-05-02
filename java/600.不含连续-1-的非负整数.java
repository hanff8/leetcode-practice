/*
 * @lc app=leetcode.cn id=600 lang=java
 * 
 * @lcpr version=21907
 *
 * [600] 不含连续1的非负整数
 */

// @lc code=start
class Solution {
    public int findIntegers(int n) {
        int res = 0;
        for (int i = 0; i <= n; ++i) {
            String s = Integer.toBinaryString(i);
            if (!s.contains("11")) {
                res++;
            }
        }
        return res;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // 5\n // @lcpr case=end
 * 
 * // @lcpr case=start // 1\n // @lcpr case=end
 * 
 * // @lcpr case=start // 2\n // @lcpr case=end
 * 
 */

