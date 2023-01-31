import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=169 lang=java
 * @lcpr version=21401
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        // Map<Integer, Integer> map = new HashMap<>();
        // int max = -1, maxVal = 0;

        // for (int val : nums) {
        // map.put(val, map.getOrDefault(val, 0) + 1);
        // if (map.get(val) > max) {
        // max = map.get(val);
        // maxVal = val;
        // }
        // }
        // return maxVal;

        // 排序
        // Arrays.sort(nums);
        // return nums[nums.length / 2];

        // 摩尔投票算法
        int count = 0;
        int candidate = 0;
        for (int i : nums) {
            if (count == 0) {
                candidate = i;
            }
            count += (i == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [3,2,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,2,1,1,1,2,2]\n
 * // @lcpr case=end
 * 
 */
