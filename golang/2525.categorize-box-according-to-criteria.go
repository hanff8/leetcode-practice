/*
 * @lc app=leetcode.cn id=2525 lang=golang
 * @lcpr version=30102
 *
 * [2525] 根据规则将箱子分类
 */

// @lcpr-template-start
package leetcode_go

// @lcpr-template-end
// @lc code=start
func categorizeBox(length int, width int, height int, mass int) string {
	MAX_NUM := 10000
	MAX_V := 1000000000
	v := length * width * height
	set := make(map[string]bool)
	if length >= MAX_NUM || width >= MAX_NUM || height >= MAX_NUM || mass >= MAX_NUM || v >= MAX_V {
		set["Bulky"] = true
	}
	if mass >= 100 {
		set["Heavy"] = true
	}
	if set["Heavy"] && set["Bulky"] {
		return "Both"
	} else if set["Heavy"] && !set["Bulky"] {
		return "Heavy"
	} else if set["Bulky"] && !set["Heavy"] {
		return "Bulky"
	} else {
		return "Neither"
	}
}

// @lc code=end

/*
// @lcpr case=start
// 1000\n35\n700\n300\n
// @lcpr case=end

// @lcpr case=start
// 200\n50\n800\n50\n
// @lcpr case=end

*/
