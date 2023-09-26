/*
 * @lc app=leetcode.cn id=LCP 50 lang=java
 * 
 * @lcpr version=21913
 *
 * [LCP 50] 宝石补给
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayDeque;

// @lc code=start
class Solution {
	public int giveGem(int[] gem, int[][] operations) {
		for (int[] op : operations) {
			int x = op[0], y = op[1];
			int gift = gem[x] / 2;
			gem[x] -= gift;
			gem[y] += gift;
		}
		return Arrays.stream(gem).max().getAsInt() - Arrays.stream(gem).min().getAsInt();
	}
}
// @lc code=end



/*
// @lcpr case=start
// [3,1,2]\n[[0,2],[2,1],[2,0]]`>\n
// @lcpr case=end

// @lcpr case=start
// [100,0,50,100]\n[[0,2],[0,1],[3,0],[3,0]]`>\n
// @lcpr case=end

// @lcpr case=start
// [0,0,0,0]\n[[1,2],[3,1],[1,2]]`>\n
// @lcpr case=end

 */

