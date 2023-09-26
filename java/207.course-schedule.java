/*
 * @lc app=leetcode.cn id=207 lang=java
 * 
 * @lcpr version=21913
 *
 * [207] 课程表
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
	int[] indegree;
	List<List<Integer>> edges;
	int[] result;

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// bfs
		// return bfs(numCourses, prerequisites);
		//dfs
		return dfs(numCourses, prerequisites);
	}


	int[] visited;
	boolean valid = true;

	private boolean dfs(int numCourses, int[][] prerequisites) {
		edges = new ArrayList<>();
		visited = new int[numCourses];

		for (int i = 0; i < numCourses; i++) {
			edges.add(new ArrayList<>());
		}

		for (int[] info : prerequisites) {
			edges.get(info[1]).add(info[0]);
		}

		for (int i = 0; i < numCourses; i++) {
			if (visited[i] == 0) {
				dfs(i);
			}
		}

		return valid;
	}

	private void dfs(int u) {
		visited[u] = 1;
		for (int v : edges.get(u)) {
			if (visited[v] == 0) {
				dfs(v);
				if (!valid) {
					return;
				}
			} else if (visited[v] == 1) {
				valid = false;
				return;
			}
		}
		visited[u] = 2;
	}


	private boolean bfs(int numCourses, int[][] prerequisites) {
		edges = new ArrayList<>();
		indegree = new int[numCourses];
		result = new int[numCourses];
		int index = 0;
		for (int i = 0; i < numCourses; i++) {
			edges.add(new ArrayList<>());
		}

		for (int[] info : prerequisites) {
			edges.get(info[1]).add(info[0]);
			++indegree[info[0]];
		}

		Queue<Integer> que = new ArrayDeque<>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				que.offer(i);
			}
		}

		while (!que.isEmpty()) {
			++index;
			int u = que.poll();
			for (int v : edges.get(u)) {
				--indegree[v];
				if (indegree[v] == 0)
					que.offer(v);
			}
		}

		return index == numCourses;
	}
}
// @lc code=end



/*
// @lcpr case=start
// 2\n[[1,0]]\n
// @lcpr case=end

// @lcpr case=start
// 2\n[[1,0],[0,1]]\n
// @lcpr case=end

 */

