/*
 * @lc app=leetcode.cn id=1761 lang=java
 * 
 * @lcpr version=21913
 *
 * [1761] 一个图中连通三元组的最小度数
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayDeque;

// @lc code=start
class Solution {
	public int minTrioDegree(int n, int[][] edges) {
		// return solution1(n, edges);
		return solution2(n.edges);
	}


	private int solution2(int n, int[][] edges) {
		
	}


	/*
	 * 时间复杂度 n^3
	 * 空间复杂度 n^2
	 */
	private int solution1(int n, int[][] edges) {
		int[][] g = new int[n][n];
		int[] degree = new int[n];
		for (int[] arr : edges) {
			int x = arr[0] - 1, y = arr[1] - 1;
			g[x][y] = 1;
			g[y][x] = 1;
			degree[x]++;
			degree[y]++;
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (g[i][j] == 1) {
					for (int k = j + 1; k < n; k++) {
						if (g[i][k] == 1 && g[j][k] == 1) {
							ans = Math.min(ans, degree[i] + degree[j] + degree[k] - 6);
						}
					}
				}
			}
		}
		return ans == Integer.MAX_VALUE ? -1 : ans;
	}
}
// @lc code=end



/*
// @lcpr case=start
// 6\n[[1,2],[1,3],[3,2],[4,1],[5,2],[3,6]]\n
// @lcpr case=end

// @lcpr case=start
// 7\n[[1,3],[4,1],[4,3],[2,5],[5,6],[6,7],[7,5],[2,6]]\n
// @lcpr case=end

 */

