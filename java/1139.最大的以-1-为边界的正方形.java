/*
 * @lc app=leetcode.cn id=1139 lang=java
 * @lcpr version=21702
 *
 * [1139] 最大的以 1 为边界的正方形
 */

// @lc code=start
class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] rs = new int[m][n + 1];
        int[][] cs = new int[n][m + 1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // 每行的前缀和
                rs[i][j + 1] = rs[i][j] + grid[i][j];
                // 每列的前缀和
                cs[j][i + 1] = cs[j][i] + grid[i][j];
            }
        }
        for (int d = Math.min(m, n); d > 0; --d) {
            for (int i = 0; i <= m - d; i++) {
                for (int j = 0; j <= n - d; j++) {
                    if (rs[i][j + d] - rs[i][j] == d && // 上边
                            cs[j][i + d] - cs[j][i] == d && // 左边
                            rs[i + d - 1][j + d] - rs[i + d - 1][j] == d && // 下边
                            cs[j + d - 1][i + d] - cs[j + d - 1][i] == d) // 右边 {
                        return d * d;
                }

            }
        }
        return 0;
    }
}

// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end

/*
 * // @lcpr case=start
 * // [[1,1,1],[1,0,1],[1,1,1]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[1,1,0,0]]\n
 * // @lcpr case=end
 * 
 */
