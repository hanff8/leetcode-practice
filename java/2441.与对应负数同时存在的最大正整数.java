/*
 * @lc app=leetcode.cn id=2441 lang=java
 * 
 * @lcpr version=21907
 *
 * [2441] 与对应负数同时存在的最大正整数
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;

// @lc code=start
class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (i < 0) {
                set.add(i);
            }
        }
        int res = -1;
        for (int i : nums) {
            if (i > 0) {
                if (set.contains(-i)) {
                    res = Math.max(res, i);
                }
            }
        }
        return res;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // [-1,2,-3,3]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [-1,10,6,7,-7,1]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [-10,8,6,7,-2,-3]\n // @lcpr case=end
 * 
 */

