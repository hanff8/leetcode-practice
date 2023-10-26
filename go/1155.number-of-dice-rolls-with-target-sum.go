/*
 * @lc app=leetcode.cn id=1155 lang=golang
 * @lcpr version=30102
 *
 * [1155] 掷骰子等于目标和的方法数
 */

// @lcpr-template-start
package leetcode_go

// @lcpr-template-end
// @lc code=start
func numRollsToTarget(n int, k int, target int) int {
	memo := make([][]int, n+1)
	for i := range memo {
		memo[i] = make([]int, target-n+1)
		for j := range memo[i] {
			memo[i][j] = -1
		}
	}
	const mod = 1_000_000_007
	var dfs func(int, int) int
	dfs = func(i int, j int) int {
		if i == 0 {
			if j == 0 {
				return 1
			}
			return 0
		}
		if memo[i][j] != -1 {
			return memo[i][j]
		}
		res := 0
		for x := 0; x < k && x <= j; x++ {
			res = ((res + dfs(i-1, j-x)) % mod)
		}
		memo[i][j] = res
		return res
	}
	return dfs(n, target-n)
}

// @lc code=end

/*
// @lcpr case=start
// 1\n6\n3\n
// @lcpr case=end

// @lcpr case=start
// 2\n6\n7\n
// @lcpr case=end

// @lcpr case=start
// 30\n30\n500\n
// @lcpr case=end

*/
