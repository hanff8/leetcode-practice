import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=2357 lang=java
 * 
 * @lcpr version=21704
 *
 * [2357] 使数组中所有元素都等于零
 */

// @lc code=start
class Solution {
    public int minimumOperations(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                subtract(nums, nums[i], i);
                ans++;
            }
        }
        return ans;
    }

    public void subtract(int[] nums, int x, int startIndex) {
        int length = nums.length;
        for (int i = startIndex; i < length; i++) {
            nums[i] -= x;
        }
    }

}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // [1,5,0,3,5]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [0]\n // @lcpr case=end
 * 
 */


