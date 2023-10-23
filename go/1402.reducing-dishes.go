/*
 * @lc app=leetcode.cn id=1402 lang=golang
 * @lcpr version=30102
 *
 * [1402] 做菜顺序
 */

// @lcpr-template-start
package leetcode_go

import "sort"

// @lcpr-template-end
// @lc code=start
func maxSatisfaction(satisfaction []int) int {
	// max := func(a, b int) int {
	// 	if a > b {
	// 		return a
	// 	}
	// 	return b
	// }
	// solution1 := func(arr []int) int {
	// 	ans := 0
	// 	n := len(arr)
	// 	dp := make([][]int, n+1)
	// 	for i := 0; i < n+1; i++ {
	// 		dp[i] = make([]int, n+1)
	// 	}
	// 	sort.Ints(arr)
	// 	for i := 1; i <= n; i++ {
	// 		for j := 1; j <= i; j++ {
	// 			dp[i][j] = dp[i-1][j-1] + arr[i-1]*j
	// 			if j < i {
	// 				dp[i][j] = max(dp[i][j], dp[i-1][j])
	// 			}
	// 			ans = max(ans, dp[i][j])
	// 		}
	// 	}
	// 	return ans
	// }
	solution2 := func(arr []int) int {
		ans, pre := 0, 0
		sort.Slice(arr, func(a, b int) bool {
			return arr[a] > arr[b]
		})

		for _, i := range arr {
			if pre+i > 0 {
				pre += i
				ans += pre
			}
		}
		return ans
	}
	// return solution1(satisfaction)
	return solution2(satisfaction)
}

// @lc code=end

/*
// @lcpr case=start
// [-1,-8,0,5,-9]\n
// @lcpr case=end

// @lcpr case=start
// [4,3,2]\n
// @lcpr case=end

// @lcpr case=start
// [-1,-4,-5]\n
// @lcpr case=end

*/
