/*
 * @lc app=leetcode.cn id=面试题 05.02 lang=java
 * 
 * @lcpr version=21708
 *
 * [面试题 05.02] 二进制数转字符串
 */

// @lc code=start
class Solution {
    public String printBin(double num) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        while (num != 0) {
            num *= 2;
            int digital = (int) num;
            sb.append(digital);
            num -= digital;
            count++;
            if (count > 32)
                return "ERROR";
        }
        return sb.toString();
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // // @lcpr case=end
 * 
 * // @lcpr case=start // // @lcpr case=end
 * 
 */


