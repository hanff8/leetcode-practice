/*
 * @lc app=leetcode.cn id=2475 lang=java
 * 
 * @lcpr version=21909
 *
 * [2475] 数组中不等三元组的数目
 */

// @lc code=start
class Solution {
    public int unequalTriplets(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [4,4,2,4,3]\n
// @lcpr case=end

// @lcpr case=start
// [1,1,1,1,1]\n
// @lcpr case=end

 */

