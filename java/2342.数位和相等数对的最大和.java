/*
 * @lc app=leetcode.cn id=2342 lang=java
 * 
 * @lcpr version=21907
 *
 * [2342] 数位和相等数对的最大和
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
    public int maximumSum(int[] nums) {
        int ans = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int res = 0;
            int tmp = nums[i];
            while (tmp != 0) {
                res += tmp % 10;
                tmp /= 10;
            }
            if (map.containsKey(res)) {
                ans = Math.max(ans, nums[i] + nums[map.get(res)]);
                map.put(res, nums[i] > nums[map.get(res)] ? i : map.get(res));
            } else {
                map.put(res, i);
            }
        }
        return ans;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // [18,43,36,13,7]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [10,12,19,14]\n // @lcpr case=end
 * 
 */

