/*
 * @lc app=leetcode.cn id=2520 lang=golang
 * @lcpr version=30102
 *
 * [2520] 统计能整除数字的位数
 */

// @lcpr-template-start
package leetcode_go

// @lcpr-template-end
// @lc code=start
func countDigits(num int) int {
	t := num
	res := 0
	for t != 0 {
		if num%(t%10) == 0 {
			res++
		}
		t /= 10
	}
	return res
}

// @lc code=end

/*
// @lcpr case=start
// 7\n
// @lcpr case=end

// @lcpr case=start
// 121\n
// @lcpr case=end

// @lcpr case=start
// 1248\n
// @lcpr case=end

*/
