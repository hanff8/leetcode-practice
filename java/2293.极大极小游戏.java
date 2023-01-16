/*
 * @lc app=leetcode.cn id=2293 lang=java
 * @lcpr version=21108
 *
 * [2293] 极大极小游戏
 */

// @lc code=start
class Solution {
    public int minMaxGame(int[] nums) {
        int[] newNums;
        // System.out.println(nums.length);

        while (true) {
            if (nums.length == 1) {
                return nums[0];
            } else {
                newNums = new int[nums.length / 2];
                for (int j = 0; j < newNums.length; j++) {
                    if (j % 2 == 0)
                        newNums[j] = Math.min(nums[2 * j], nums[2 * j + 1]);
                    else {
                        newNums[j] = Math.max(nums[2 * j], nums[2 * j + 1]);
                        // System.out.println(nums[2 * j] + " " + nums[2 * j + 1]);
                    }
                    // System.out.println("newNums:" + newNums[j]);
                }
                nums = newNums;
            }
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,3,5,2,4,8,2,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [3]\n
 * // @lcpr case=end
 * 
 */
