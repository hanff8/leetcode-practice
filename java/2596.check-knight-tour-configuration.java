/*
 * @lc app=leetcode.cn id=2596 lang=java
 * 
 * @lcpr version=21913
 *
 * [2596] 检查骑士巡视方案
 */

// @lc code=start

import java.util.Arrays;

class Solution {
	public boolean checkValidGrid(int[][] grid) {
		// return solution1(grid);
		return solution2(grid);
	}

	private boolean solution2(int[][] grid) {
		int[][] directions = new int[][] {{1, 2}, {1, -2}, {-1, -2}, {-1, 2}, {2, 1}, {2, -1},
				{-2, 1}, {-2, -1}};
		int n = grid.length;
		if (grid[0][0] != 0) {
			return false;
		}

		int count = n * n;
		int px = 0, py = 0;
		for (int i = 1; i < count;) {
			int num = grid[px][py];
			for (int[] direct : directions) {
				int nx = px + direct[0];
				int ny = py + direct[1];
				if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == num + 1) {
					px = nx;
					py = ny;
					break;
				}
			}
			++i;
			if (grid[px][py] != num + 1) {
				return false;
			}
		}
		return true;
	}

	private boolean solution1(int[][] grid) {
		int n = grid.length;
		if (grid[0][0] != 0) {
			return false;
		}
		// 起点->终点
		int[][] indices = new int[n * n][2];

		// indices数组实际上就是将 grid中对应的步数的真实位置存进数组中，方便后面计算
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				indices[grid[i][j]][0] = i;
				indices[grid[i][j]][1] = j;
			}
		}

		for (int i = 1; i < n * n; i++) {
			int dx = Math.abs(indices[i][0] - indices[i - 1][0]);
			int dy = Math.abs(indices[i][1] - indices[i - 1][1]);
			if (dx * dy != 2) {
				return false;
			}
		}
		return true;
	}
}
// @lc code=end



/*
// @lcpr case=start
// [[0,11,16,5,20],[17,4,19,10,15],[12,1,8,21,6],[3,18,23,14,9],[24,13,2,7,22]]\n
// @lcpr case=end

// @lcpr case=start
// [[0,3,6],[5,8,1],[2,7,4]]\n
// @lcpr case=end

 */

