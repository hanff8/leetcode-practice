/*
 * @lc app=leetcode.cn id=1330 lang=java
 * @lcpr version=21907
 *
 * [1330] 翻转子数组得到最大的数组值
 */

// @lc code=start
class Solution {
    public int maxValueAfterReverse(int[] nums) {
        int base = 0, d = 0, n = nums.length;
        int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int a = nums[i - 1], b = nums[i];
            int dab = Math.abs(a - b);
            base += dab;
            mx = Math.max(mx, Math.min(a, b));
            mn = Math.min(mn, Math.max(a, b));
            d = Math.max(d, Math.max(Math.abs(nums[0] - b) - dab, // i=0
                                     Math.abs(nums[n - 1] - a) - dab)); // j=n-1
        }
        return base + Math.max(d, 2 * (mx - mn));
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,3,1,5,4]\n
// @lcpr case=end

// @lcpr case=start
// [2,4,9,24,2,1,10]\n
// @lcpr case=end

 */

