import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 * 
 * @lcpr version=21906
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0)
                return ans;

            // 去重
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[l] + nums[r] + nums[i];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[l], nums[i], nums[r]));
                    // 去重
                    while (l < r && nums[l] == nums[l + 1])
                        ++l;
                    while (l < r && nums[r] == nums[r - 1])
                        --r;

                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                }
            }
        }
        return ans;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // [-1,0,1,2,-1,-4]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [0,1,1]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [0,0,0]\n // @lcpr case=end
 * 
 */

