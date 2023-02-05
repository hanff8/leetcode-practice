import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1210 lang=java
 * @lcpr version=21401
 *
 * [1210] 穿过迷宫的最少移动次数
 */

// @lc code=start
class Solution {
    private static int[][] DIRS = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };

    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        var vis = new boolean[n][n][2];
        List<int[]> q = new ArrayList<int[]>();
        vis[0][0][0] = true;

        // 初始位置
        q.add(new int[] { 0, 0, 0 });
        for (int step = 1; !q.isEmpty(); ++step) {
            var tmp = q;
            q = new ArrayList<>();
            for (int[] t : tmp) {
                for (var d : DIRS) {
                    int x = t[0] + d[0], y = t[1] + d[1], s = t[2] ^ d[2];
                    int x2 = x + s, y2 = y + (s ^ 1);
                    if (x2 < n && y2 < n && !vis[x][y][s] && grid[x][y] == 0 && grid[x2][y2] == 0
                            && (d[2] == 0 || grid[x + 1][y + 1] == 0)) {

                        if (x == n - 1 && y == n - 2)
                            return step;
                        vis[x][y][s] = true;
                        q.add(new int[] { x, y, s });
                    }
                }
            }

        }
        return -1;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * //
 * [[0,0,0,0,0,1],[1,1,0,0,1,0],[0,0,0,0,1,1],[0,0,1,0,1,0],[0,1,1,0,0,0],[0,1,1
 * ,0,0,0]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * //
 * [[0,0,1,1,1,1],[0,0,0,0,1,1],[1,1,0,0,0,1],[1,1,1,0,0,1],[1,1,1,0,0,1],[1,1,1
 * ,0,0,0]]\n
 * // @lcpr case=end
 * 
 */
