//给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 2, prices = [2,4,1]
//输出：2
//解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。 
//
// 示例 2： 
//
// 
//输入：k = 2, prices = [3,2,6,5,0,3]
//输出：7
//解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 100 
// 1 <= prices.length <= 1000 
// 0 <= prices[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 1056 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIv {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIv().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][][] memo;

        public int maxProfit(int k, int[] prices) {
//            return recursion(k, prices);
            int n = prices.length;
            memo = new int[n + 1][k + 2][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < k + 2; j++) {
                    Arrays.fill(memo[i][j], -1);
                }
            }
            return dfs(prices, k, prices.length - 1, 0);
        }

        private int dfs(int[] prices, int k, int i, int hold) {
            if (k < 0) return Integer.MIN_VALUE / 2;
            if (i < 0) return hold == 1 ? Integer.MIN_VALUE / 2 : 0;

            if (memo[i][k][hold] != -1) return memo[i][k][hold];

            /**
             * 倒着思考
             */
            if (hold == 1) {
                return memo[i][k][1] = Math.max(dfs(prices, k, i - 1, 1), dfs(prices, k, i - 1, 0) - prices[i]);
            }
            return memo[i][k][0] = Math.max(dfs(prices, k, i - 1, 0), dfs(prices, k - 1, i - 1, 1) + prices[i]);
        }

        private static int recursion(int k, int[] prices) {
            int n = prices.length;
            int[][] dp = new int[k + 2][2];
            for (int i = 0; i < k + 2; i++) {
                Arrays.fill(dp[i], Integer.MIN_VALUE / 2);
            }
            for (int i = 1; i < k + 2; i++) {
                dp[i][0] = 0;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < k + 2; j++) {
                    dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] + prices[i]);
                    dp[j][1] = Math.max(dp[j][1], dp[j][0] - prices[i]);
                }
            }
            return dp[k + 1][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
