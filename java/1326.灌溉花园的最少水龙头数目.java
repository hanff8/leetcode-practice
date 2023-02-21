import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1326 lang=java
 * 
 * @lcpr version=21704
 *
 * [1326] 灌溉花园的最少水龙头数目
 */

// @lc code=start
class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] rightMost = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int r = ranges[i];
            if (i > r) {
                rightMost[i - r] = i + r;
            } else {
                rightMost[0] = Math.max(rightMost[0], i + r);
            }
        }
        // System.out.println(Arrays.toString(rightMost));

        int ans = 0;
        int curRight = 0; // 已建造桥的右端点
        int nextRight = 0; // 下一座桥的右端点
        for (int i = 0; i < n; i++) { // 没有到n,因为已经是终点了
            nextRight = Math.max(nextRight, rightMost[i]);
            if (i == curRight) {
                if (i == nextRight) // 没有更远的桥了，到达不了终点
                    return -1;
                curRight = nextRight;
                ++ans;
            }

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
 * // @lcpr case=start // 5\n[3,4,1,1,0,0]\n // @lcpr case=end
 * 
 * // @lcpr case=start // 3\n[0,0,0,0]\n // @lcpr case=end
 * 
 */


