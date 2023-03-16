import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 * 
 * @lcpr version=21801
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public void backTrack(int[] nums, List<List<Integer>> res, int cur) {
        for (int i = cur; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] || cur > i)
                continue;
            backTrack(nums, res, cur + 1);

        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            List<Integer> tmp = new ArrayList<>();
            int j = 0;
            while (j < nums.length) {
                tmp.add(nums[(j + i) % n]);
                ++j;
            }
            res.add(tmp);
        }
        return res;
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // [1,2,3]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [0,1]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1]\n // @lcpr case=end
 * 
 */


