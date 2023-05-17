/*
 * @lc app=leetcode.cn id=1016 lang=golang
 * @lcpr version=21907
 *
 * [1016] 子串能表示从 1 到 N 数字的二进制串
 */
package leetcode_go

// @lc code=start
func queryString(s string, n int) bool {
	seen := map[int]struct{}{}
	for i, b := range s {
		x := int(b - '0')
		if x == 0 {
			continue
		}
		for j := i + 1; x <= n; j++ {
			seen[x] = struct{}{}
			if j == len(s) {
				break
			}
			x = (x << 1) | int(s[j]-'0')
		}
	}
	return len(seen) == n
}

// @lc code=end

/*
// @lcpr case=start
// "0110"\n3\n
// @lcpr case=end

// @lcpr case=start
// "0110"\n4\n
// @lcpr case=end

*/
