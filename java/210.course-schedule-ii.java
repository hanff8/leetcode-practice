/*
 * @lc app=leetcode.cn id=210 lang=java
 * 
 * @lcpr version=21913
 *
 * [210] 课程表 II
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
	// 存储有向图
	List<List<Integer>> edges;

	// 标记每个节点的状态：0 未搜索,1 搜索中还没回溯到,2 已完成
	int[] visited;

	// 用数组来模拟栈
	int[] result;

	// 判断有向图中是否有环
	boolean vaild = true;

	//栈下标
	int index;

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		// dfs
		// return solution1(numCourses, prerequisites);
		// bfs

		return solution2(numCourses, prerequisites);

	}

	// 每个节点的入度
	int[] indegree;


	private int[] solution2(int numCourses, int[][] prerequisites) {
		edges = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			edges.add(new ArrayList<>());
		}
		indegree = new int[numCourses];
		result = new int[numCourses];
		index = 0;
		for (int[] info : prerequisites) {
			edges.get(info[1]).add(info[0]);
			++indegree[info[0]];
		}

		Queue<Integer> queue = new ArrayDeque<>();
		// 将所有入度为0的节点加入队列中
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int u = queue.poll();
			result[index++] = u;
			for (int v : edges.get(u)) {
				--indegree[v];
				if (indegree[v] == 0) {
					queue.offer(v);
				}
			}
		}

		if (index != numCourses) {
			return new int[0];
		}
		return result;
	}

	private int[] solution1(int numCourses, int[][] prerequisites) {
		edges = new ArrayList<>();

		for (int i = 0; i < numCourses; i++) {
			edges.add(new ArrayList<>());
		}
		visited = new int[numCourses];
		result = new int[numCourses];
		index = numCourses - 1;
		for (int[] info : prerequisites) {
			edges.get(info[1]).add(info[0]);
		}

		for (int i = 0; i < numCourses && vaild; i++) {
			if (visited[i] == 0) {
				dfs(i);
			}
		}

		if (!vaild) {
			return new int[0];
		}
		return result;
	}

	public void dfs(int u) {
		// 将节点标记为 [搜索中]
		visited[u] = 1;

		// 搜索其相邻节点
		// 只要发现有环，立刻停止搜索
		for (int v : edges.get(u)) {
			if (visited[v] == 0) {
				dfs(v);
				if (!vaild) {
					return;
				}
			}
			// 如果【搜索中】说明找到了环
			else if (visited[v] == 1) {
				vaild = false;
				return;
			}
		}
		// 将节点标记为[已完成]
		visited[u] = 2;
		result[index--] = u;

	}
}
// @lc code=end



/*
// @lcpr case=start
// 2\n[[1,0]]\n
// @lcpr case=end

// @lcpr case=start
// 4\n[[1,0],[2,0],[3,1],[3,2]]\n
// @lcpr case=end

// @lcpr case=start
// 1\n[]\n
// @lcpr case=end

 */

