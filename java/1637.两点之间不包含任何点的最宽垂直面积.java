import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1637 lang=java
 * 
 * @lcpr version=21901
 *
 * [1637] 两点之间不包含任何点的最宽垂直面积
 */

// @lc code=start
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            return a[0] - b[0];
        });
        int max = 0;
        int n = points.length;
        for (int i = 1; i < n; i++) {
            if (points[i][0] - points[i - 1][0] > max)
                max = points[i][0] - points[i - 1][0];
        }
        return max;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // [[8,7],[9,9],[7,4],[9,7]]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]\n // @lcpr case=end
 * 
 */


