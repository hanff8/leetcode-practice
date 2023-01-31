import javax.lang.model.util.ElementScanner6;

/*
 * @lc app=leetcode.cn id=2319 lang=java
 * @lcpr version=21401
 *
 * [2319] 判断矩阵是否是一个 X 矩阵
 */

// @lc code=start
class Solution {
    public boolean checkXMatrix(int[][] grid) {
        // for (int i = 0; i < grid.length; i++) {
        // for (int j = 0; j < grid.length; j++) {
        // if (grid[i][j] != 0) {
        // if (i != j && (i + j) != grid.length - 1)
        // return false;
        // } else {
        // if (i == j || (i + j) == grid.length - 1)
        // return false;
        // }
        // }
        // }
        // return true;
        // 优化判断逻辑 像这种需要判断「两个条件都为真」「两个条件都为假」的逻辑，都可以直接用这两个条件的 bool 值作比较，从而简化代码逻辑：
        // if ((grid[i][j] == 0) == (i == j || i + j == n - 1))
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (i == j || (i + j) == grid.length - 1) {
                    if (grid[i][j] == 0)
                        return false;
                } else {
                    if (grid[i][j] != 0)
                        return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[5,7,0],[0,3,1],[0,5,0]]\n
 * // @lcpr case=end
 * 
 */
