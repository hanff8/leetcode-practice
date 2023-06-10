/*
 * @lc app=leetcode.cn id=2455 lang=java
 * 
 * @lcpr version=21908
 *
 * [2455] 可被三整除的偶数的平均值
 */

// @lc code=start
class Solution {
    public int averageValue(int[] nums) {
        int ans = 0, n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 6 == 0) {
                ans += nums[i];
                ++n;
            }
        }
        return ans == 0 ? 0 : ans / n;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,3,6,10,12,15]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,4,7,10]\n
// @lcpr case=end

 */

