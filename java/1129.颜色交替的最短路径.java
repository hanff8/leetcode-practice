import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1129 lang=java
 * @lcpr version=21401
 *
 * [1129] 颜色交替的最短路径
 */

// @lc code=start
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // List<Integer>[][] next = new List[2][n];
        // for (var list : next) {
        // Arrays.setAll(list, k -> new ArrayList<>());
        // }
        // // 存入list中
        // for (var e : redEdges) {
        // next[0][e[0]].add(e[1]);
        // }
        // for (var e : blueEdges) {
        // next[1][e[0]].add(e[1]);
        // }

        // Deque<int[]> arrayDeque = new ArrayDeque<>();
        // arrayDeque.offer(new int[] { 0, 0 }); // 从0开始走红色边
        // arrayDeque.offer(new int[] { 0, 1 }); // 从0开始走蓝色边

        // boolean[][] vis = new boolean[n][2];
        // // ans 记录0到每个节点的最短路径，也就是返回的结果值
        // int[] ans = new int[n];
        // Arrays.fill(ans, -1);
        // int level = 0; // 层数
        // while (!arrayDeque.isEmpty()) {
        // for (int i = arrayDeque.size(); i > 0; i--) {
        // var p = arrayDeque.poll();
        // int m = p[0], k = p[1];
        // if (ans[m] == -1) {
        // ans[m] = level;
        // }
        // vis[m][k] = true;
        // // 取反，接下来走另外一种颜色的边
        // k ^= 1;
        // for (int node : next[k][m]) {
        // // 没有走过的，则加入队列中
        // if (!vis[node][k]) {
        // arrayDeque.offer(new int[] { node, k });
        // }
        // }
        // }
        // ++level;
        // }
        // return ans;

        List<Integer>[][] next = new List[2][n];
        for (var list : next) {
            Arrays.setAll(list, k -> new ArrayList<>());
        }
        for (var e : redEdges) {
            next[0][e[0]].add(e[1]);
        }
        for (var e : blueEdges) {
            next[1][e[0]].add(e[1]);
        }
        boolean[][] vis = new boolean[n][2];
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<int[]> arrayDeque = new ArrayDeque<>();
        arrayDeque.offer(new int[] { 0, 0 });
        arrayDeque.offer(new int[] { 0, 1 });
        int level = 0;
        while (!arrayDeque.isEmpty()) {
            for (int k = arrayDeque.size(); k > 0; k--) {
                var p = arrayDeque.poll();
                int i = p[0], c = p[1];
                if (ans[i] == -1) {
                    ans[i] = level;
                }
                vis[i][c] = true;
                c ^= 1;
                // 遍历 节点 i 的边，找出没有走过的加入队列中
                for (int j : next[c][i]) {
                    if (!vis[j][c]) {
                        arrayDeque.add(new int[] { j, c });
                    }
                }
            }
            ++level;
        }
        return ans;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 3\n[[0,1],[1,2]]\n[]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 3\n[[0,1]]\n[[2,1]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 3\n[[1,0]]\n[[2,1]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 3\n[[0,1]]\n[[1,2]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 3\n[[0,1],[0,2]]\n[[1,0]]\n
 * // @lcpr case=end
 * 
 */
