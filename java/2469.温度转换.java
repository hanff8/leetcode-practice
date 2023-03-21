/*
 * @lc app=leetcode.cn id=2469 lang=java
 * @lcpr version=21801
 *
 * [2469] 温度转换
 */

// @lc code=start
class Solution {
    public double[] convertTemperature(double celsius) {
        return new double[] { celsius + 273.15, celsius * 1.80 + 32.0 };
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end

/*
 * // @lcpr case=start
 * // 36.50\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 122.11\n
 * // @lcpr case=end
 * 
 */
