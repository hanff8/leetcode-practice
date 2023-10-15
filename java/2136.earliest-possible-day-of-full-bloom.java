/*
 * @lc app=leetcode.cn id=2136 lang=java
 * 
 * @lcpr version=21917
 *
 * [2136] 全部开花的最早一天
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
	public int earliestFullBloom(int[] plantTime, int[] growTime) {
		int n = plantTime.length;
		var id = new Integer[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
		Arrays.sort(id, (i, j) -> growTime[j] - growTime[i]);
		int ans = 0, days = 0;
		for (int i : id) {
			days += plantTime[i];
			ans = Math.max(ans, days + growTime[i]);
		}
		return ans;
	}
}
// @lc code=end



/*
// @lcpr case=start
// [1,4,3]\n[2,3,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,2]\n[2,1,2,1]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n[1]\n
// @lcpr case=end

 */

