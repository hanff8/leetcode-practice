import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=62 lang=java
 * 
 * @lcpr version=21704
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // int i = 1, j = 1;
        // while (i < m && j < n) {
        // dp[i][j] = dp[i][j - 1] + dp[j][i - 1];
        // i++;
        // j++;
        // }
        dp[0][1] = 1;
        dp[1][0] = 1;
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0)
                    dp[i][j] = 1;
                else if (j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }


        return dp[m - 1][n - 1];
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // 3\n7\n // @lcpr case=end
 * 
 * // @lcpr case=start // 3\n2\n // @lcpr case=end
 * 
 * // @lcpr case=start // 7\n3\n // @lcpr case=end
 * 
 * // @lcpr case=start // 3\n3\n // @lcpr case=end
 * 
 */


