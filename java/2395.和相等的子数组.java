import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=2395 lang=java
 * 
 * @lcpr version=21801
 *
 * [2395] 和相等的子数组
 */

// @lc code=start
class Solution {
    public boolean findSubarrays(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < n; i++) {
            if (map.containsKey(nums[i] + nums[i - 1])) {
                return true;
            } else {
                map.put(nums[i] + nums[i - 1], 1);
            }
        }
        return false;
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // [4,2,4]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1,2,3,4,5]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [0,0,0]\n // @lcpr case=end
 * 
 */


