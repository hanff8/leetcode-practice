/*
 * @lc app=leetcode.cn id=1617 lang=java
 * @lcpr version=21801
 *
 * [1617] 统计子树中城市之间最大距离
 */

// @lc code=start
class Solution {
    int mask;
    int diameter;

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            int x = edge[0] - 1;
            int y = edge[1] - 1;
            adj[x].add(y);
            adj[y].add(x);
        }

        int[] ans = new int[n - 1];
        for (int i = 1; i < (1 << n); i++) {
            int root = 32 - Integer.numberOfLeadingZeros(i) - 1;
            mask = i;
            diameter = 0;
            dfs(root, adj);
            if (mask == 0 && diameter > 0) {
                ans[diameter - 1]++;
            }
        }
        return ans;
    }

    public int dfs(int root, List<Integer>[] adj) {
        int first = 0, second = 0;
        mask &= ~(1 << root);
        for (int vertex : adj[root]) {
            if ((mask & (1 << vertex)) != 0) {
                mask &= ~(1 << vertex);
                int distance = 1 + dfs(vertex, adj);
                if (distance > first) {
                    second = first;
                    first = distance;
                } else if (distance > second) {
                    second = distance;
                }
            }
        }
        diameter = Math.max(diameter, first + second);
        return first;
    }
}

// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
// @lcpr case=start
// 4\n[[1,2],[2,3],[2,4]]\n
// @lcpr case=end

// @lcpr case=start
// 2\n[[1,2]]\n
// @lcpr case=end

// @lcpr case=start
// 3\n[[1,2],[2,3]]\n
// @lcpr case=end

 */


