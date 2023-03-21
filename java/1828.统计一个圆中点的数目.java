/*
 * @lc app=leetcode.cn id=1828 lang=java
 * 
 * @lcpr version=21801
 *
 * [1828] 统计一个圆中点的数目
 */

// @lc code=start
class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;
        int[] res = new int[queries.length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < points.length; j++) {
                res[i] += isInternal(points[j], queries[i]) ? 1 : 0;
            }
        }
        return res;
    }

    boolean isInternal(int[] p, int[] cir) {
        if (Math.pow(cir[0] - p[0], 2) + Math.pow(cir[1] - p[1], 2) <= Math.pow(cir[2], 2)) {
            return true;
        }
        return false;
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // [[1,3],[3,3],[5,3],[2,2]]\n[[2,3,1],[4,3,1],[1,1,2]]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [[1,1],[2,2],[3,3],[4,4],[5,5]]\n[[1,2,2],[2,2,2],[4,3,2],[4,3,3]]\n
 * // @lcpr case=end
 * 
 */


