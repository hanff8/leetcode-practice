/*
 * @lc app=leetcode.cn id=2352 lang=java
 * 
 * @lcpr version=21909
 *
 * [2352] 相等行列对
 */

// @lc code=start
class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int res = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int i = 0;
                boolean flag = true;
                while (i < n) {
                    if (grid[row][i] != grid[i][col])
                        flag = false;
                    ++i;
                }
                if (flag)
                    res++;
            }
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[3,2,1],[1,7,6],[2,7,7]]\n
// @lcpr case=end

// @lcpr case=start
// [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]\n
// @lcpr case=end

 */

