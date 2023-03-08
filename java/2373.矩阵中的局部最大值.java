/*
 * @lc app=leetcode.cn id=2373 lang=java
 * @lcpr version=21707
 *
 * [2373] 矩阵中的局部最大值
 */

// @lc code=start
class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        res[i][j] = Math.max(res[i][j], grid[x][y]);
                    }
                }
            }
        }
        return res;
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
 * // [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]\n
 * // @lcpr case=end
 * 
 */
