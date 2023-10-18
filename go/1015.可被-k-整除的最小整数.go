/*
 * @lc app=leetcode.cn id=1015 lang=golang
 * @lcpr version=21907
 *
 * [1015] 可被 K 整除的最小整数
 */
package leetcode_go

import "fmt"

// @lc code=start
func smallestRepunitDivByK(k int) int {
	if k%2 == 0 || k%5 == 0 {
		return -1
	}
	x := 1 % k
	println("test")
	for i := 1; ; i++ { // 一定有解
		if x == 0 {
			return i
		}
		x = (x*10 + 1) % k
	}

}
func main() {
	res := smallestRepunitDivByK(5)
	fmt.Println(res)
}

// @lc code=end

/*
// @lcpr case=start
// 1\n
// @lcpr case=end

// @lcpr case=start
// 2\n
// @lcpr case=end

// @lcpr case=start
// 3\n
// @lcpr case=end

*/
