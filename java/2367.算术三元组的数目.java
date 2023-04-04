import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=2367 lang=java
 * 
 * @lcpr version=21901
 *
 * [2367] 算术三元组的数目
 */

// @lc code=start
class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        // 暴力
        // int ans = 0;
        // for (int i = 0; i < nums.length; i++) {
        // for (int j = i + 1; j < nums.length; j++) {
        // for (int j2 = j + 1; j2 < nums.length; j2++) {
        // if (nums[j] - nums[i] == diff && diff == nums[j2] - nums[j])
        // ans++;
        // }
        // }
        // }
        // return ans;

        // hash
        // Set<Integer> set = new HashSet<>();

        // int ans = 0;
        // for (int i = 0; i < nums.length; i++) {
        // set.add(nums[i]);
        // if (set.contains(nums[i] - diff) && set.contains(nums[i] - 2 * diff))
        // ++ans;
        // }
        // return ans;
        // 三指针
        int n = nums.length;
        int ans = 0;
        for (int i = 0, j = 1, k = 2; i < n - 2; ++i) {
            // 数组严格递增
            while (j < n - 2 && nums[j] - nums[i] < diff)
                ++j;
            while (k < n - 1 && nums[k] - nums[j] < diff)
                ++k;
            if (nums[k] - nums[j] == diff && nums[k] - nums[j] == nums[j] - nums[i])
                ++ans;
        }
        return ans;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // [0,1,4,6,7,10]\n3\n // @lcpr case=end
 * 
 * // @lcpr case=start // [4,5,6,7,8,9]\n2\n // @lcpr case=end
 * 
 */


