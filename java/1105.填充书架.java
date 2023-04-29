import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1105 lang=java
 * 
 * @lcpr version=21906
 *
 * [1105] 填充书架
 */

// @lc code=start
class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int maxHeight = 0, curWidth = 0;
            for (int j = i; j >= 0; --j) {
                curWidth += books[j][0];
                if (curWidth > shelfWidth)
                    break;
                maxHeight = Math.max(maxHeight, books[j][1]);
                dp[i + 1] = Math.min(dp[i + 1], dp[j] + maxHeight);
            }
        }
        return dp[n];
    }

    public int dfs(int[][] books) {

    }
}
// @lc code=end



/*
 * // @lcpr case=start // [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]]\n4\n // @lcpr case=end
 * 
 * // @lcpr case=start // [[1,3],[2,4],[3,2]]\n6\n // @lcpr case=end
 * 
 */

