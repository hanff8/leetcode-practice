/*
 * @lc app=leetcode.cn id=1605 lang=java
 * 
 * @lcpr version=21801
 *
 * [1605] 给定行和列的和求可行矩阵
 */

// @lc code=start
class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length, m = colSum.length;
        int[][] matrix = new int[n][m];
        int i = 0, j = 0;
        while (i < n && j < m) {
            int v = Math.min(rowSum[i], colSum[j]);
            matrix[i][j] = v;
            rowSum[i] -= v;
            colSum[j] -= v;
            if (rowSum[i] == 0)
                ++i;
            if (colSum[j] == 0)
                ++j;
        }
        return matrix;
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // [3,8]\n[4,7]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [5,7,10]\n[8,6,8]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [14,9]\n[6,9,8]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1,0]\n[1]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [0]\n[0]\n // @lcpr case=end
 * 
 */


