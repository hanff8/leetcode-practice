/*
 * @lc app=leetcode.cn id=704 lang=java
 * @lcpr version=21401
 *
 * [704] 二分查找
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int pos = -1;
        int left = 0, right = nums.length - 1, mid = left + right / 2;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
            else {
                pos = mid;
                break;
            }
        }
        return pos;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [-1,0,3,5,9,12]\n9\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [-1,0,3,5,9,12]\n2\n
 * // @lcpr case=end
 * 
 */
