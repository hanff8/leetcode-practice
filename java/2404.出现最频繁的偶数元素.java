import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=2404 lang=java
 * 
 * @lcpr version=21906
 *
 * [2404] 出现最频繁的偶数元素
 */

// @lc code=start
class Solution {
    public int mostFrequentEven(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[] {-1, 0};
        int n = nums.length;
        int freq = 0, cur = nums[0];
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                if (nums[i] == cur) {
                    freq++;
                } else {
                    cur = nums[i];
                    freq = 1;
                }
            }
            ans = freq > ans[1] ? new int[] {cur, freq} : ans;
        }
        return ans[0];
    }
}
// @lc code=end



/*
 * // @lcpr case=start // [0,1,2,2,4,4,1]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [4,4,4,9,2,4]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [29,47,21,41,13,37,25,7]\n // @lcpr case=end
 * 
 */

