/*
 * @lc app=leetcode.cn id=2165 lang=java
 * 
 * @lcpr version=21907
 *
 * [2165] 重排数字的最小值
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
// @lc code=start


class Solution {
    public long smallestNumber(long num) {
        if (num == 0)
            return num;
        char[] nums = String.valueOf(num).toCharArray();

        if (nums[0] == '-') {
            Arrays.sort(nums, 1, nums.length);
            for (int i = 1; i <= nums.length / 2; ++i) {
                char ch = nums[i];
                nums[i] = nums[nums.length - i];
                nums[nums.length - i] = ch;
            }

            int i = 1, j = 1;
            while (nums[j] == '0')
                ++j;
            if (j != i) {

                char ch = nums[j];
                nums[j] = nums[i];
                nums[i] = ch;
            }
            return Long.valueOf(String.valueOf(nums));
        } else {
            Arrays.sort(nums);
            int i = 0, j = 0;
            while (nums[j] == '0')
                ++j;
            if (j == i) {
            } else {
                char ch = nums[j];
                nums[j] = nums[i];
                nums[i] = ch;
            }

            return Long.valueOf(String.valueOf(nums));
        }

    }
}
// @lc code=end



/*
 * // @lcpr case=start // 310\n // @lcpr case=end
 * 
 * // @lcpr case=start // -7605\n // @lcpr case=end
 * 
 */

