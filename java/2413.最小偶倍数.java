/*
 * @lc app=leetcode.cn id=2413 lang=java
 * 
 * @lcpr version=21906
 *
 * [2413] 最小偶倍数
 */

// @lc code=start
class Solution {
    public int smallestEvenMultiple(int n) {
        return n << (n & 1);
    }
}
// @lc code=end



/*
 * // @lcpr case=start // 5\n // @lcpr case=end
 * 
 * // @lcpr case=start // 6\n // @lcpr case=end
 * 
 */

