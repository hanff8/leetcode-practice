/*
 * @lc app=leetcode.cn id=2316 lang=golang
 * @lcpr version=30102
 *
 * [2316] 统计无向图中无法互相到达点对数
 */

// @lcpr-template-start
package leetcode_go

// @lcpr-template-end
// @lc code=start
type UnionFind struct {
	parents []int
	sizes   []int
}

func newUnionFind(n int) *UnionFind {
	parents, sizes := make([]int, n), make([]int, n)
	for i := 0; i < n; i++ {
		parents[i], sizes[i] = i, 1
	}
	return &UnionFind{
		parents: parents,
		sizes:   sizes,
	}
}

func (uf *UnionFind) find(x int) int {
	if uf.parents[x] == x {
		return x
	} else {
		uf.parents[x] = uf.find(uf.parents[x])
		return uf.parents[x]
	}
}

func (uf *UnionFind) union(x, y int) {
	rx, ry := uf.find(x), uf.find(y)
	if rx != ry {
		if uf.sizes[rx] > uf.sizes[ry] {
			uf.parents[ry] = rx
			uf.sizes[rx] += uf.sizes[ry]
		} else {
			uf.parents[rx] = ry
			uf.sizes[ry] += uf.sizes[rx]
		}
	}
}

func (uf *UnionFind) getSize(x int) int {
	return uf.sizes[x]
}

func countPairs(n int, edges [][]int) int64 {
	// return solution1(n, edges)
	return solution2(n, edges)
}

func solution2(n int, edges [][]int) int64 {
	uf := newUnionFind(n)

	for _, e := range edges {
		uf.union(e[0], e[1])
	}
	var cnt int64
	for i := 0; i < n; i++ {
		cnt += int64(n - uf.getSize(uf.find(i)))
	}
	return cnt / 2
}

func solution1(n int, edges [][]int) int64 {
	g := make([][]int, n)
	for _, e := range edges {
		g[e[0]] = append(g[e[0]], e[1])
		g[e[1]] = append(g[e[1]], e[0])
	}
	visited := make([]bool, n)
	var cnt int64
	var dfs func(int) int
	dfs = func(i int) int {
		visited[i] = true
		count := 1
		for _, x := range g[i] {
			if !visited[x] {
				count += dfs(x)
			}
		}
		return count
	}
	for i := 0; i < n; i++ {
		if !visited[i] {
			count := dfs(i)
			cnt += int64(count * (n - count))
		}
	}
	return cnt / 2
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
