/*
 * @lc app=leetcode.cn id=605 lang=java
 * 
 * @lcpr version=21917
 *
 * [605] 种花问题
 */

// @lc code=start
class Solution {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		for (int i = 0; i < flowerbed.length && n > 0;) {
			if (flowerbed[i] == 1) {
				i += 2;
			} else if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
				i += 2;
				n--;
			} else {
				i += 3;
			}
		}
		return n <= 0;
	}
}
// @lc code=end



/*
// @lcpr case=start
// [1,0,0,0,1]\n1\n
// @lcpr case=end

// @lcpr case=start
// [1,0,0,0,1]\n2\n
// @lcpr case=end

 */

