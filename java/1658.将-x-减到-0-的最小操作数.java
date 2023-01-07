import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1658 lang=java
 * @lcpr version=21105
 *
 * [1658] 将 x 减到 0 的最小操作数
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = Arrays.stream(nums).sum();
        int lsum = 0, rsum = sum;
        int right = 0;
        int ans = nums.length + 1;
        if (sum < x) {
            return -1;
        }
        for (int left = -1; left < nums.length; ++left) {
            if (left != -1) {
                lsum += nums[left];
            }
            while (right < nums.length && lsum + rsum > x) {
                rsum -= nums[right];
                ++right;
            }
            if (lsum + rsum == x) {
                ans = Math.min(ans, (left + 1) + (nums.length - right));
            }
            System.out.println(ans);
        }
        return ans > nums.length ? -1 : ans;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,1,4,2,3]\n5\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [5,6,7,8,9]\n4\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [3,2,20,1,1,3]\n10\n
 * // @lcpr case=end
 * 
 */
