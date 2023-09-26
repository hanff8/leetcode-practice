/*
 * @lc app=leetcode.cn id=1162 lang=java
 * 
 * @lcpr version=21914
 *
 * [1162] 地图分析
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

/**
 * BFS
 * 
 * 根据BFS的精神，最后搜索到的就是满足题目要求的
 */
class Solution {
	public int maxDistance(int[][] grid) {
		int n = grid.length;
		int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

		Queue<int[]> que = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1)
					que.add(new int[] {i, j});
			}
		}

		boolean hasOcean = false;
		int[] p = null;
		while (!que.isEmpty()) {
			p = que.poll();
			int x = p[0], y = p[1];

			for (int[] dir : directions) {
				int newX = dir[0] + x, newY = dir[1] + y;
				if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0) {
					grid[newX][newY] = grid[x][y] + 1;
					hasOcean = true;
					que.offer(new int[] {newX, newY});
				}

			}

		}
		if (p == null || !hasOcean)
			return -1;
		return grid[p[0]][p[1]] - 1;

	}
}
// @lc code=end



/*
// @lcpr case=start
// [[1,0,1],[0,0,0],[1,0,1]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,0,0],[0,0,0],[0,0,0]]\n
// @lcpr case=end

 */

