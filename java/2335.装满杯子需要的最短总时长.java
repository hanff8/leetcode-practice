import java.util.Arrays;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/*
 * @lc app=leetcode.cn id=2335 lang=java
 * @lcpr version=21505
 *
 * [2335] 装满杯子需要的最短总时长
 */

// @lc code=start
class Solution {
    public int fillCups(int[] amount) {

        // int re = 0;
        // Arrays.sort(amount);
        // while (amount[2] != 0) {

        // amount[2]--;
        // amount[1]--;
        // System.out.println(Arrays.toString(amount));
        // Arrays.sort(amount);
        // re++;
        // }
        // return re;
        Arrays.sort(amount);
        if (amount[0] + amount[1] <= amount[2])
            return amount[2];
        else {
            return (amount[0] + amount[1] + amount[2] + 1) / 2;
        }
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
 * // [1,4,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [5,4,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [5,0,0]\n
 * // @lcpr case=end
 * 
 */
