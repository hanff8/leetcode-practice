/*
 * @lc app=leetcode.cn id=982 lang=java
 * 
 * @lcpr version=21708
 *
 * [982] 按位与为零的三元组
 */

// @lc code=start
class Solution {
    public int countTriplets(int[] nums) {
        int ans = 0;
        int[] tmp = new int[1 << 16];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                ++tmp[nums[i] & nums[j]];
            }
        }
        for (int i : nums) {
            for (int j = 0; j < (1 << 16); j++) {
                if ((i & j) == 0) {
                    ans += tmp[j];
                }
            }
        }

        return ans;
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // [2,1,3]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [0,0,0]\n // @lcpr case=end
 * 
 */


