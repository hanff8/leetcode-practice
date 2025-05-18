/*
 * @lc app=leetcode.cn id=3184 lang=java
 * 
 * @lcpr version=30204
 *
 * [3184] 构成整天的下标对数目 I
 */

// @lcpr-template-start
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

// @lcpr-template-end
// @lc code=start
class Solution {
	public int countCompleteDayPairs(int[] hours) {
		Arrays.sort(hours);
		int n = hours.length;
		int left = 0, right = n - 1;
		while (left < right) {
			// while(left+righ  t)
		}
	}
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [12,12,30,24,24]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [72,48,24,3]\n
 * // @lcpr case=end
 * 
 */
