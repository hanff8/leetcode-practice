import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2500 lang=java
 * 
 * @lcpr version=21801
 *
 * [2500] 删除每行中的最大值
 */

// @lc code=start
class Solution {
    public int deleteGreatestValue(int[][] grid) {
        // int ans = 0;
        // int row = grid.length;
        // int colum = grid[0].length;
        // // int[][] max = new int[grid[0].length][grid[0].length];
        // int[] columMax = new int[colum];
        // for (int k = 0; k < colum; k++) {
        // for (int i = 0; i < row; i++) {
        // int rowMax = 0;
        // int pos = 0;
        // for (int j = 0; j < colum; j++) {
        // if (grid[i][j] > rowMax) {
        // rowMax = grid[i][j];
        // pos = j;
        // }
        // }
        // grid[i][pos] = 0;
        // columMax[k] = rowMax > columMax[k] ? rowMax : columMax[k];
        // }
        // System.out.println(columMax[k]);
        // ans += columMax[k];
        // }
        // return ans;
        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
        }
        int ans = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                max = grid[j][i] > max ? grid[j][i] : max;
            }
            ans += max;
        }
        return ans;
        // ans += Arrays.stream(max).max().getAsInt();
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // [[1,2,4],[3,3,1]]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [[10]]\n // @lcpr case=end
 * 
 */


