/*
 * @lc app=leetcode.cn id=2678 lang=golang
 * @lcpr version=30102
 *
 * [2678] 老人的数目
 */

// @lcpr-template-start
package leetcode_go

import "strconv"

// @lcpr-template-end
// @lc code=start
func countSeniors(details []string) int {
	count := 0
	for i := 0; i < len(details); i++ {
		age, _ := strconv.Atoi(details[i][11:13])
		if age > 60 {
			count++
		}
	}
	return count
}

// @lc code=end

/*
// @lcpr case=start
// ["7868190130M7522","5303914400F9211","9273338290F4010"]\n
// @lcpr case=end

// @lcpr case=start
// ["1313579440F2036","2921522980M5644"]\n
// @lcpr case=end

*/
