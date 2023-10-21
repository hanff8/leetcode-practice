/*
 * @lc app=leetcode.cn id=2316 lang=java
 * 
 * @lcpr version=30102
 *
 * [2316] 统计无向图中无法互相到达点对数
 */


// @lcpr-template-start
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayDeque;
import java.util.Deque;

// @lcpr-template-end
// @lc code=start
class Solution {
	List<Integer>[] g;
	boolean[] visited;
	long cnt = 0;

	public long countPairs(int n, int[][] edges) {
		// return solution1(n, edges);
		return solution2(n, edges);
	}

	private long solution2(int n, int[][] edges) {
		UnionFind uf = new UnionFind(n);
		for (var edge : edges) {
			uf.union(edge[0], edge[1]);
		}
		long res = 0;
		for (int i = 0; i < n; i++) {
			System.out.println(uf.getSizes(uf.find(i)));
			res += n - uf.getSizes(uf.find(i));
		}
		return res / 2;
	}

	private long solution1(int n, int[][] edges) {
		g = new List[n];
		Arrays.setAll(g, a -> new ArrayList<>());
		visited = new boolean[n];
		for (var edge : edges) {
			g[edge[0]].add(edge[1]);
			g[edge[1]].add(edge[0]);
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				long count = dfs(i);
				System.out.println(count);
				cnt += count * (n - count);
			}
		}
		return cnt / 2;
	}

	private int dfs(int i) {
		visited[i] = true;
		int count = 1;
		for (var v : g[i]) {
			if (visited[v])
				continue;
			count += dfs(v);
		}
		return count;
	}

	class UnionFind {
		int[] parents;
		int[] sizes;

		public UnionFind(int n) {
			parents = new int[n];
			for (int i = 0; i < n; i++) {
				parents[i] = i;
			}
			sizes = new int[n];
			Arrays.fill(sizes, 1);
		}

		public int find(int x) {
			if (parents[x] == x) {
				return x;
			} else {
				parents[x] = find(parents[x]);
				return parents[x];
			}
		}

		public void union(int x, int y) {
			int rx = find(x), ry = find(y);
			if (rx != ry) {
				if (sizes[rx] > sizes[ry]) {
					parents[ry] = rx;
					sizes[rx] += sizes[ry];
				} else {
					parents[rx] = ry;
					sizes[ry] += sizes[rx];
				}
			}
		}

		public int[] getParents() {
			return parents;
		}

		public int getSizes(int x) {
			return sizes[x];
		}
	}
}
// @lc code=end



/*
// @lcpr case=start
// 3\n[[0,1],[0,2],[1,2]]\n
// @lcpr case=end

// @lcpr case=start
// 7\n[[0,2],[0,5],[2,4],[1,6],[5,4]]\n
// @lcpr case=end

 */

