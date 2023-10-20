//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入：prices = [3,3,5,0,0,3,1,4]
//输出：6
//解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2： 
//
// 
//输入：prices = [1,2,3,4,5]
//输出：4
//解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3： 
//
// 
//输入：prices = [7,6,4,3,1] 
//输出：0 
//解释：在这个情况下, 没有交易完成, 所以最大利润为 0。 
//
// 示例 4： 
//
// 
//输入：prices = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 10⁵ 
// 0 <= prices[i] <= 10⁵ 
// 
//
// Related Topics 数组 动态规划 👍 1555 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] prices;
        int[][][] memo;

        public int maxProfit(int[] prices) {
//            return dfs_solution(prices);
            return solution2(prices, 2);
        }

        private int solution2(int[] prices, int k) {
            int n = prices.length;
            int[][][] f = new int[n + 1][k + 2][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= k + 1; j++) {
                    Arrays.fill(f[i][j], Integer.MIN_VALUE / 2); // 防止溢出
                }
            }
            for (int i = 1; i < k + 2; i++) {
                f[0][i][0] = 0;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < k + 2; j++) {
                    f[i + 1][j][0] = Math.max(f[i][j][0], f[i][j][1] + prices[i]);
                    f[i + 1][j][1] = Math.max(f[i][j][1], f[i][j - 1][0] - prices[i]);
                }
            }
            return f[n][k + 1][0];
        }

        /**
         * time limit exceeded
         */
        private int dfs_solution(int[] prices) {
            this.prices = prices;
            int n = prices.length;
            this.memo = new int[n][3][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    Arrays.fill(memo[i][j], -1);
                }
            }
            return dfs(n - 1, 0, 2);
        }

        private int dfs(int i, int hold, int k) {
            if (k < 0) return Integer.MIN_VALUE / 2;
            if (i < 0) {
                return hold == 1 ? Integer.MIN_VALUE / 2 : 0;
            }
            if (memo[i][k][hold] != -1) return memo[i][k][hold];
            if (hold == 1) {
                return memo[i][k][hold] = Math.max(dfs(i - 1, 1, k), dfs(i - 1, 0, k - 1) - prices[i]);
            }
            return memo[i][k][hold] = Math.max(dfs(i - 1, 0, k), dfs(i - 1, 1, k) + prices[i]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
