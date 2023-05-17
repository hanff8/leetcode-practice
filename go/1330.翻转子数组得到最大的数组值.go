/*
 * @lc app=leetcode.cn id=1330 lang=golang
 * @lcpr version=21907
 *
 * [1330] 翻转子数组得到最大的数组值
 */
package main

import "math"

// @lc code=start
func maxValueAfterReverse(nums []int) int {
	base, d, n := 0, 0, len(nums)
	mx, mn := math.MinInt, math.MaxInt
	for i := 1; i < n; i++ {
		a, b := nums[i-1], nums[i]
		base += abs(a - b)
		mx = max(mx, min(a, b))
		mn = min(mn, max(a, b))
		d = max(d, max(abs(nums[0]-b)-abs(a-b), // i=0
			abs(nums[n-1]-a)-abs(a-b))) // j=n-1
	}
	return base + max(d, 2*(mx-mn))
}
func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}
func min(a int, b int) int {
	if a > b {
		return b
	} else {
		return a
	}
}
func max(a int, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}

// @lc code=end

/*
// @lcpr case=start
// [2,3,1,5,4]\n
// @lcpr case=end

// @lcpr case=start
// [2,4,9,24,2,1,10]\n
// @lcpr case=end

*/
