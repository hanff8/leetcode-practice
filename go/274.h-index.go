/*
 * @lc app=leetcode.cn id=274 lang=golang
 * @lcpr version=30103
 *
 * [274] H 指数
 */

// @lcpr-template-start
package leetcode_go

// @lcpr-template-end
// @lc code=start
func hIndex(citations []int) int {
	n := len(citations)
	left, right := 0, n
	var mid int
	for left <= right {
		mid = (left + right) / 2
		cnt := 0
		for _, v := range citations {
			if v >= mid {
				cnt++
			}
		}
		if cnt >= mid {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return left - 1
}

// @lc code=end

/*
// @lcpr case=start
// [3,0,6,1,5]\n
// @lcpr case=end

// @lcpr case=start
// [1,3,1]\n
// @lcpr case=end

*/
