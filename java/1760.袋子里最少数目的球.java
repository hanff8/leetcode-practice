import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1760 lang=java
 * @lcpr version=21103
 *
 * [1760] 袋子里最少数目的球
 */

// @lc code=start
class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        int ans = 0;

        while (left <= right) {
            int y = (left + right) / 2;
            long ops = 0;
            for (int i : nums) {
                ops += (i - 1) / y;
            }
            if (ops <= maxOperations) {
                ans = y;
                right = y - 1;
            } else {
                left = y + 1;
            }
        }
        return ans;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [9]\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,4,8,2]\n4\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [7,17]\n2\n
 * // @lcpr case=end
 * 
 */
