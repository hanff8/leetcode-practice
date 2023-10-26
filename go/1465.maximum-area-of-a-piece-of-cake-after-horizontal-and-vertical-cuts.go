/*
 * @lc app=leetcode.cn id=1465 lang=golang
 * @lcpr version=30102
 *
 * [1465] 切割后面积最大的蛋糕
 */

// @lcpr-template-start
package leetcode_go

import (
	"sort"
)

// @lcpr-template-end
// @lc code=start
func maxArea(h int, w int, horizontalCuts []int, verticalCuts []int) int {
	mod := 1000000007

	sort.Ints(horizontalCuts)
	sort.Ints(verticalCuts)
	return calMax(horizontalCuts, h) * calMax(verticalCuts, w) % mod
}

func calMax(arr []int, boarder int) int {
	res, pre := 0, 0
	for _, i := range arr {
		res = max(i-pre, res)
		pre = i
	}
	return max(res, boarder-pre)
}
func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}

// @lc code=end

/*
// @lcpr case=start
// 5\n4\n[1,2,4]\n[1,3]\n
// @lcpr case=end

// @lcpr case=start
// 5\n4\n[3,1]\n[1]\n
// @lcpr case=end

// @lcpr case=start
// 5\n4\n[3]\n[3]\n
// @lcpr case=end

*/
