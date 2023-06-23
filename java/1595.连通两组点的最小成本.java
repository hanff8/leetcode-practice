/*
 * @lc app=leetcode.cn id=1595 lang=java
 * 
 * @lcpr version=21909
 *
 * [1595] 连通两组点的最小成本
 */

// @lc code=start
class Solution {
    public int connectTwoGroups(List<List<Integer>> cost) {
        int size1 = cost.size(), size2 = cost.get(0).size(), m = 1 << size2;
        int[][] dp = new int[size1 + 1][m];
        for (int i = 0; i <= size1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= size1; i++) {
            for (int s = 0; s < m; s++) {
                for (int k = 0; k < size2; k++) {
                    if ((s & (1 << k)) == 0) {
                        continue;
                    }
                    dp[i][s] = Math.min(dp[i][s], dp[i][s ^ (1 << k)] + cost.get(i - 1).get(k));
                    dp[i][s] = Math.min(dp[i][s], dp[i - 1][s] + cost.get(i - 1).get(k));
                    dp[i][s] = Math.min(dp[i][s], dp[i - 1][s ^ (1 << k)] + cost.get(i - 1).get(k));
                }
            }
        }
        return dp[size1][m - 1];
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[15, 96], [36, 2]]\n
// @lcpr case=end

// @lcpr case=start
// [[1, 3, 5], [4, 1, 1], [1, 5, 3]]\n
// @lcpr case=end

// @lcpr case=start
// [[2, 5, 1], [3, 4, 7], [8, 1, 2], [6, 2, 4], [3, 8, 8]]\n
// @lcpr case=end

 */

