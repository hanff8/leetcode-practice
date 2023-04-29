import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 * 
 * @lcpr version=21906
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0)
            return res;
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[n];
        Arrays.sort(nums);
        dfs(path, res, nums, 0, n, visited);
        return res;
    }

    public void dfs(List<Integer> path, List<List<Integer>> res, int[] nums, int depth, int len,
            boolean[] visited) {
        if (len == depth) {
            res.add(new ArrayList<>(path));
            return;
        }
        // int prev = 0;
        for (int i = 0; i < len; ++i) {
            // !visited[i-1] 限制一下两个相邻的重复数字的访问顺序
            if ((i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) || visited[i])
                continue;
            path.add(nums[i]);
            visited[i] = true;
            dfs(path, res, nums, depth + 1, len, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
// @lc code=end



/*
 * // @lcpr case=start // [1,1,2]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1,2,3]\n // @lcpr case=end
 * 
 */

