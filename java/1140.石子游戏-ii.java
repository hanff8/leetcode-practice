/*
 * @lc app=leetcode.cn id=1140 lang=java
 * 
 * @lcpr version=21704
 *
 * [1140] 石子游戏 II
 */

// @lc code=start
class Solution {
    public int stoneGameII(int[] piles) {
        int len = piles.length, sum = 0;
        int[][] dp = new int[len][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            sum += piles[i];
            for (int M = 1; M <= len; ++M) {
                if (i + 2 * M >= len) {
                    dp[i][M] = sum;
                } else {
                    for (int x = 1; x <= 2 * M; x++) {
                        dp[i][M] = Math.max(dp[i][M], sum - dp[i + x][Math.max(M, x)]);
                    }
                }
            }
        }
        return dp[0][1];
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // [2,7,9,4,4]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1,2,3,4,5,100]\n // @lcpr case=end
 * 
 */


