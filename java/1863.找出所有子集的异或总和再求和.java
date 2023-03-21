import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1863 lang=java
 * 
 * @lcpr version=21801
 *
 * [1863] 找出所有子集的异或总和再求和
 */

// @lc code=start
class Solution {
    int ans = 0;

    public void dfs(int[] nums, int cur, int val) {
        if (cur == nums.length) {
            ans += val;
            return;
        }
        dfs(nums, cur + 1, val);
        dfs(nums, cur + 1, val ^ nums[cur]);
    }

    public int subsetXORSum(int[] nums) {
        dfs(nums, 0, ans);
        return ans;
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // [1,3]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [5,1,6]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [3,4,5,6,7,8]\n // @lcpr case=end
 * 
 */


