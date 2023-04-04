import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1039 lang=java
 * 
 * @lcpr version=21901
 *
 * [1039] 多边形三角剖分的最低得分
 */

// @lc code=start
class Solution {
    private int[][] memo;
    private int[] v;

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        v = values;
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, n - 1);
    }

    public int dfs(int i, int j) {
        if (i + 1 == j)
            return 0;
        if (memo[i][j] != -1)
            return memo[i][j];
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; ++k) {
            res = Math.min(dfs(i, k) + dfs(k, j) + v[i] * v[j] * v[k], res);
        }
        return memo[i][j] = res;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // [1,2,3]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [3,7,4,5]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1,3,1,4,1,5]\n // @lcpr case=end
 * 
 */


