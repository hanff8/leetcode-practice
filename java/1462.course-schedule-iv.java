/*
 * @lc app=leetcode.cn id=1462 lang=java
 * 
 * @lcpr version=21913
 *
 * [1462] 课程表 IV
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

import java.util.ArrayList;

class Solution {
	public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites,
			int[][] queries) {
		// return Bfs(numCourses, prerequisites, queries);
		return dfs(numCourses, prerequisites, queries);
	}

	private List<Boolean> dfs(int numCourses, int[][] prerequisites, int[][] queries) {

		List<Integer>[] g = new List[numCourses];
		Arrays.setAll(g, a -> new ArrayList<>());
		boolean[] vi = new boolean[numCourses];
		boolean[][] isPre = new boolean[numCourses][numCourses];
		for (int[] info : prerequisites) {
			g[info[0]].add(info[1]);
		}
		for (int i = 0; i < numCourses; i++) {
			dfs(g, isPre, vi, i);
		}
		List<Boolean> res = new ArrayList<>();
		for (int[] query : queries) {
			res.add(isPre[query[0]][query[1]]);
		}
		return res;

	}

	private void dfs(List<Integer>[] g, boolean[][] isPre, boolean[] vi, int cur) {
		if (vi[cur]) {
			return;
		}
		vi[cur] = true;
		for (int ne : g[cur]) {
			dfs(g, isPre, vi, ne);
			isPre[cur][ne] = true;
			for (int i = 0; i < isPre.length; i++) {
				isPre[cur][i] = isPre[cur][i] | isPre[ne][i];
			}
		}
	}

	private List<Boolean> Bfs(int numCourses, int[][] prerequisites, int[][] queries) {
		List<Integer>[] g = new List[numCourses];
		Arrays.setAll(g, a -> new ArrayList<>());
		int[] inDegree = new int[numCourses];
		boolean[][] isPre = new boolean[numCourses][numCourses];

		for (int[] info : prerequisites) {
			++inDegree[info[1]];
			g[info[0]].add(info[1]);
		}

		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 0; i < numCourses; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int ne : g[cur]) {
				isPre[cur][ne] = true;
				// 这一步是是用来串联起类似这种[1,2][2,3][3,4]这种依赖
				for (int i = 0; i < numCourses; i++) {
					isPre[i][ne] = isPre[i][ne] | isPre[i][cur];
				}
				--inDegree[ne];
				if (inDegree[ne] == 0) {
					queue.offer(ne);
				}
			}
		}
		List<Boolean> res = new ArrayList<>();
		for (int[] query : queries) {
			res.add(isPre[query[0]][query[1]]);
		}
		return res;
	}
}
// @lc code=end



/*
// @lcpr case=start
// 2\n[[1,0]]\n[[0,1],[1,0]]\n
// @lcpr case=end

// @lcpr case=start
// 2\n[]\n[[1,0],[0,1]]\n
// @lcpr case=end

// @lcpr case=start
// 3\n[[1,2],[1,0],[2,0]]\n[[1,0],[1,2]]\n
// @lcpr case=end

 */

