/*
 * @lc app=leetcode.cn id=1615 lang=java
 * 
 * @lcpr version=21801
 *
 * [1615] 最大网络秩
 */

// @lc code=start
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {

        boolean[][] connect = new boolean[n][n];
        int[] degree = new int[n];
        for (int[] v : roads) {
            connect[v[0]][v[1]] = true;
            connect[v[1]][v[0]] = true;
            degree[v[0]]++;
            degree[v[1]]++;
        }
        int maxRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = degree[i] + degree[j] + (connect[i][j] ? -1 : 0);
                maxRank = Math.max(maxRank, rank);
            }
        }
        return maxRank;
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // 4\n[[0,1],[0,3],[1,2],[1,3]]\n // @lcpr case=end
 * 
 * // @lcpr case=start // 5\n[[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]\n // @lcpr case=end
 * 
 * // @lcpr case=start // 8\n[[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]\n // @lcpr case=end
 * 
 */


