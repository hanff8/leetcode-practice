/*
 * @lc app=leetcode.cn id=121 lang=java
 * 
 * @lcpr version=21917
 *
 * [121] 买卖股票的最佳时机
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
import java.util.Deque;
// @lc code=start


class Solution {
	public int maxProfit(int[] prices) {
		int ans = 0;
		int minPrice = prices[0];
		for (int p : prices) {
			ans = Math.max(ans, p - minPrice);
			minPrice = Math.min(minPrice, p);
		}
		return ans;
	}
}
// @lc code=end



/*
// @lcpr case=start
// [7,1,5,3,6,4]\n
// @lcpr case=end

// @lcpr case=start
// [7,6,4,3,1]\n
// @lcpr case=end

 */

