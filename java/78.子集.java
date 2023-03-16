import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 * 
 * @lcpr version=21801
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    // 动态规划 当前的总的子集集合 = 上一个数的子集+上一个子集数add当前数的子集
    // public List<List<Integer>> subsets(int[] nums) {
    // List<List<Integer>> res = new ArrayList<>();
    // List<Integer> init = new ArrayList<>();
    // res.add(init);
    // for (int i = 0; i < nums.length; i++) {
    // int num = nums[i];
    // int times = res.size();
    // for (int j = 0; j < times; j++) {
    // List<Integer> tmp = res.get(j);
    // var sub = new ArrayList<Integer>(tmp);
    // sub.add(num);
    // res.add(sub);
    // }
    // }
    // return res;
    // }

    // public void dfs(int cur, int[] nums, List<List<Integer>> res, List<Integer> tmp) {
    // if (cur == nums.length) {
    // res.add(new ArrayList<Integer>(tmp));
    // return;
    // }
    // tmp.add(nums[cur]);
    // dfs(cur + 1, nums, res, tmp);
    // tmp.remove(tmp.size() - 1);
    // dfs(cur + 1, nums, res, tmp);
    // }
    // public List<List<Integer>> subsets(int[] nums) {
    // List<List<Integer>> res = new ArrayList<>();
    // List<Integer> tmp = new ArrayList<>();
    // dfs(0, nums, res, tmp);
    // return res;
    // }

    public void backTrack(int[] nums, int i, List<Integer> sub, List<List<Integer>> res) {
        for (int j = i; j < nums.length; j++) {
            // 剪枝
            if (j > i && nums[j] == nums[j - 1])
                continue;
            sub.add(nums[j]);
            res.add(new ArrayList<>(sub));
            backTrack(nums, j + 1, sub, res);
            sub.remove(sub.size() - 1);
        }
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        backTrack(nums, 0, new ArrayList<Integer>(), res);
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
 * // @lcpr case=start // [0]\n // @lcpr case=end
 * 
 */


