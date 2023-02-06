/*
 * @lc app=leetcode.cn id=2303 lang=java
 * @lcpr version=21108
 *
 * [2303] 计算应缴税款总额
 */

// @lc code=start
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double result = 0;
        int pre = 0;
        for (int[] is : brackets) {
            if (income > is[0]) {
                result += (is[0] - pre) * is[1] * 0.01;
            } else {
                result += (income - pre) * is[1] * 0.01;
                break;
            }
            pre = is[0];
        }
        return result;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[3,50],[7,10],[12,25]]\n10\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[1,0],[4,25],[5,50]]\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[2,50]]\n0\n
 * // @lcpr case=end
 * 
 */
