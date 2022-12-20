import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1971 lang=java
 * @lcpr version=21103
 *
 * [1971] 寻找图中是否存在路径
 */

// @lc code=start
class Solution {
    // 并查集

    // int findNext(int[] pa, int x) {
    // // return pa[x] == x ? x : findNext(pa, pa[x]);
    // if (pa[x] == x) {
    // return x;
    // }
    // x = findNext(pa, pa[x]);
    // return x;
    // }

    // void merge(int[] pa, int x, int y) {
    // x = findNext(pa, x);
    // y = findNext(pa, y);
    // pa[x] = y;
    // }

    // public boolean validPath(int n, int[][] edges, int source, int destination) {
    // // 初始化并查集
    // int[] pa = new int[n];
    // for (int i = 0; i < pa.length; i++) {
    // pa[i] = i;
    // }
    // for (int i = 0; i < edges.length; i++) {
    // merge(pa, edges[i][0], edges[i][1]);
    // }

    // if (findNext(pa, source) == findNext(pa, destination))
    // return true;

    // return false;
    // }

    // 广度优先
    // public boolean validPath(int n, int[][] edges, int source, int destination) {
    // List<Integer>[] adj = new List[n];

    // for (int i = 0; i < n; i++) {
    // adj[i] = new ArrayList<Integer>();
    // }

    // for (int[] edge : edges) {
    // int x = edge[0], y = edge[1];
    // adj[x].add(y);
    // adj[y].add(x);
    // }

    // boolean[] visited = new boolean[n];
    // Deque<Integer> que = new LinkedList<>();

    // que.offer(source);
    // visited[source] = true;
    // while (!que.isEmpty()) {
    // int head = que.poll();
    // if (head == destination) {
    // break;
    // }
    // for (int next : adj[head]) {
    // if (!visited[next]) {
    // que.offer(next);
    // visited[next] = true;
    // }
    // }
    // }

    // return visited[destination];
    // }
    // 深度优先 dfs
    boolean dfs(List<Integer>[] arr, boolean[] visited, int source, int destination) {
        if (source == destination) {
            return true;
        }
        visited[source] = true;
        for (int next : arr[source]) {
            if (!visited[next] && dfs(arr, visited, next, destination)) {
                return true;
            }
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] arr = new List[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            arr[x].add(y);
            arr[y].add(x);
        }
        boolean[] visited = new boolean[n];
        return dfs(arr, visited, source, destination);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 3\n[[0,1],[1,2],[2,0]]\n0\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 6\n[[0,1],[0,2],[3,5],[5,4],[4,3]]\n0\n5\n
 * // @lcpr case=end
 * 
 */
