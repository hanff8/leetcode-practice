/*
 * @lc app=leetcode.cn id=275 lang=golang
 * @lcpr version=30103
 *
 * [275] H 指数 II
 */

// @lcpr-template-start
package leetcode_go

import "sort"

// @lcpr-template-end
// @lc code=start
func hIndex(citations []int) int {
	n := len(citations)

	return n - sort.Search(n, func(x int) bool {
		return citations[x] >= n-x
	})

}

// @lc code=end

/*
// @lcpr case=start
// [0,1,3,5,6]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,100]\n
// @lcpr case=end

*/
