/*
 * @lc app=leetcode.cn id=797 lang=java
 * 
 * @lcpr version=21907
 *
 * [797] 所有可能的路径
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Deque;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
// @lc code=start


class Solution {
    // public void dfs(Deque<Integer> tmp, List<List<Integer>> res, int x, int[][] graph, int n) {
    // if (x == n) {
    // res.add(new ArrayList<>(tmp));
    // return;
    // }
    // for (var val : graph[x]) {
    // tmp.offerLast(val);
    // // x 传的是val
    // dfs(tmp, res, val, graph, n);
    // tmp.pollLast();
    // }
    // }

    // public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

    // List<List<Integer>> res = new ArrayList<>();

    // Deque<Integer> tmp = new ArrayDeque<>();
    // tmp.offerLast(0);
    // dfs(tmp, res, 0, graph, graph.length - 1);
    // return res;
    // }
    public void dfs(List<Integer> tmp, List<List<Integer>> res, int[][] gra, int i) {
        if (i == gra.length - 1) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (var val : gra[i]) {
            tmp.add(val);
            dfs(tmp, res, gra, val);
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(list, res, graph, 0);
        return res;
    }

}
// @lc code=end



/*
 * // @lcpr case=start // [[1,2],[3],[3],[]]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [[4,3,1],[3,2,4],[3],[4],[]]\n // @lcpr case=end
 * 
 */

