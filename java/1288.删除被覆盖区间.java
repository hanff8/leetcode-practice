import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1288 lang=java
 * @lcpr version=21801
 *
 * [1288] 删除被覆盖区间
 */

// @lc code=start
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // int ans = intervals.length;
        // for (int i = 0; i < intervals.length; i++) {
        // for (int j = 0; j < intervals.length; j++) {
        // if (i != j && intervals[j][0] <= intervals[i][0] && intervals[i][1] <=
        // intervals[j][1]) {
        // --ans;
        // break;
        // }
        // }

        // }
        // return ans;
        int n = intervals.length;
        int ans = n;
        Arrays.sort(intervals, (o1, o2) -> {
            // 重要
            if (o1[0] == o2[0])
                return o2[1] - o1[1];
            else
                return o1[0] - o2[0];
        });
        for (int[] is : intervals) {
            System.out.println(Arrays.toString(is));
        }
        int rmax = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][1] <= rmax)
                --ans;
            else
                rmax = intervals[i][1];
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
 * // @lcpr case=start
 * // [[1,4],[3,6],[2,8]]\n
 * // @lcpr case=end
 * 
 */
