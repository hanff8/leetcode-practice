/*
 * @lc app=leetcode.cn id=807 lang=java
 * 
 * @lcpr version=21907
 *
 * [807] 保持城市天际线
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int ans = 0;
        int m = grid.length, n = grid[0].length;
        int[] maxRow = new int[n];
        int[] maxCol = new int[m];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                maxCol[i] = Math.max(maxCol[i], grid[j][i]);
                maxRow[i] = Math.max(maxRow[i], grid[i][j]);
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ans += Math.min(maxRow[i], maxCol[j]) - grid[i][j];
            }
        }
        return ans;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [[0,0,0],[0,0,0],[0,0,0]]\n // @lcpr case=end
 * 
 */

