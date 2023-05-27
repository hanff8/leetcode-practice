/*
 * @lc app=leetcode.cn id=1091 lang=java
 * 
 * @lcpr version=21908
 *
 * [1091] 二进制矩阵中的最短路径
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.Queue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayDeque;

// @lc code=start
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int n = grid.length;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[] {0, 0});
        dist[0][0] = 1;
        while (!que.isEmpty()) {
            int[] arr = que.poll();
            int x = arr[0], y = arr[1];
            if (x == n - 1 && y == n - 1) {
                return dist[x][y];
            }
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    //越界
                    if (x + dx < 0 || y + dy < 0 || x + dx >= n || y + dy >= n)
                        continue;
                    // 单元格不为0或者已经被访问
                    //dist[x + dx][y + dy] <= dist[x][y] + 1 需要理解
                    if (grid[x + dx][y + dy] == 1 || dist[x + dx][y + dy] <= dist[x][y] + 1)
                        continue;
                    dist[x + dx][y + dy] = dist[x][y] + 1;
                    que.offer(new int[] {x + dx, y + dy});
                }
            }
        }
        return -1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[0,1],[1,0]]\n
// @lcpr case=end

// @lcpr case=start
// [[0,0,0],[1,1,0],[1,1,0]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,0,0],[1,1,0],[1,1,0]]\n
// @lcpr case=end

 */

