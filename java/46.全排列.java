import java.util.ArrayList;
import java.util.Collections;
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

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n == 0)
            return res;
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[n];

        // dfs(path, res, n, 0, nums, visited);

        for (int num : nums) {
            path.add(num);
        }
        dfs3(res, path, 0, nums);
        return res;
    }

    // 回溯
    public void dfs(List<Integer> path, List<List<Integer>> res, int len, int depth, int[] nums,
            boolean[] visited) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                path.add(nums[i]);
                visited[i] = true;

                dfs(path, res, len, depth + 1, nums, visited);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }

    public void dfs3(List<List<Integer>> res, List<Integer> path, int depth, int[] nums) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = depth; i < nums.length; ++i) {
            Collections.swap(path, depth, i);
            dfs3(res, path, depth + 1, nums);
            Collections.swap(path, depth, i);
        }
    }

    // 不回溯
    public void dfs2(List<Integer> path, List<List<Integer>> res, int len, int depth, int[] nums,
            boolean[] visited) {
        if (depth == len) {
            res.add(path);
            return;
        }
        for (int i = 0; i < len; ++i) {
            if (!visited[i]) {
                List<Integer> newPath = new ArrayList<>();
                boolean[] newUsed = new boolean[len];
                System.arraycopy(newUsed, 0, visited, 0, len);
                newPath.add(nums[i]);
                newUsed[i] = true;
                dfs(newPath, res, len, depth + 1, nums, newUsed);
            }
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
 * // @lcpr case=start // [1,2,3]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [0,1]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1]\n // @lcpr case=end
 * 
 */


