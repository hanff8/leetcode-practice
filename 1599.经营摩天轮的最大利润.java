/*
 * @lc app=leetcode.cn id=1599 lang=java
 * 
 * @lcpr version=21801
 *
 * [1599] 经营摩天轮的最大利润
 */

// @lc code=start
class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int wait = 0;
        int profit = 0;
        int i = 0;
        int ans = -1, max = 0;
        int n = customers.length;

        while (wait > 0 || i < n) {
            wait += i < n ? customers[i] : 0;
            // if (wait > 4) {
            // profit = Math.max(profit, ans * boardingCost * 4 - ans * runningCost);
            // } else {
            // profit = Math.max(profit, profit + (wait * boardingCost - runningCost));
            // }
            int up = Math.min(4, wait);
            profit += up * boardingCost - runningCost;
            ++i;
            if (profit > max) {
                max = profit;
                ans = i;
            }
            // System.out
            // .println("profit: " + profit + " wait before:" + wait + " index:" + (ans - 1));
            wait -= up;
        }
        return ans;
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // [8,3]\n5\n6\n // @lcpr case=end
 * 
 * // @lcpr case=start // // @lcpr case=end
 * 
 * // @lcpr case=start // [3,4,0,5,1]\n1\n92\n // @lcpr case=end
 * 
 */


