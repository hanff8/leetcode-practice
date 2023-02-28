/*
 * @lc app=leetcode.cn id=1144 lang=java
 * 
 * @lcpr version=21706
 *
 * [1144] 递减元素使数组呈锯齿状
 */

// @lc code=start
class Solution {
    public int movesToMakeZigzag(int[] nums) {
        return Math.min(help(nums, 0), help(nums, 1));
    }

    public int help(int[] nums, int pos) {
        int res = 0;
        for (int i = pos; i < nums.length; i += 2) {
            int a = 0;
            if (i - 1 >= 0) {
                a = Math.max(a, nums[i] - nums[i - 1] + 1);
            }
            if (i + 1 < nums.length) {
                a = Math.max(a, nums[i] - nums[i + 1] + 1);
            }
            res += a;
        }
        return res;
    }

}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // [1,2,3]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [9,6,1,6,2]\n // @lcpr case=end
 * 
 */


