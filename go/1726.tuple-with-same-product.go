/*
 * @lc app=leetcode.cn id=1726 lang=golang
 * @lcpr version=30102
 *
 * [1726] 同积元组
 */

// @lcpr-template-start
package leetcode_go

// @lcpr-template-end
// @lc code=start
func tupleSameProduct(nums []int) int {
	n := len(nums)
	cnt := make(map[int]int)
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			cnt[nums[i]*nums[j]]++
		}
	}
	ans := 0
	for _, v := range cnt {
		ans += (v - 1) * v * 4
	}
	return ans
}

// @lc code=end

/*
// @lcpr case=start
// [2,3,4,6]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,4,5,10]\n
// @lcpr case=end

*/
