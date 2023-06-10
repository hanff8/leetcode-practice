/*
 * @lc app=leetcode.cn id=2465 lang=java
 * 
 * @lcpr version=21908
 *
 * [2465] 不同的平均值数目
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.IntStream;
// @lc code=start


class Solution {
    public int distinctAverages(int[] nums) {
        Set<Double> set = new HashSet<>();
        int n = nums.length;
        int index = 0;
        while (index < n) {
            Arrays.sort(nums);

            set.add((nums[index] + nums[n - index - 1]) / 2.0);
            index++;
        }
        return set.size();
    }
}
// @lc code=end



/*
// @lcpr case=start
// [4,1,4,0,3,5]\n
// @lcpr case=end

// @lcpr case=start
// [1,100]\n
// @lcpr case=end

 */

