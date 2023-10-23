/*
 * @lc app=leetcode.cn id=1402 lang=java
 * 
 * @lcpr version=30102
 *
 * [1402] 做菜顺序
 */


// @lcpr-template-start
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.ArrayDeque;
import java.util.Deque;

// @lcpr-template-end
// @lc code=start
class Solution {
	public int maxSatisfaction(int[] satisfaction) {
		// return getDp(satisfaction);
		return solution2(satisfaction);
	}

	private int solution2(int[] satisfaction) {
		satisfaction = IntStream.of(satisfaction).boxed().sorted(Comparator.reverseOrder())
				.mapToInt(Integer::intValue).toArray();

		int ans = 0, pre = 0;
		for (int i : satisfaction) {
			if (pre + i > 0) {
				pre += i;;
				ans += pre;
			}
		}
		return ans;
	}

	private int getDp(int[] satisfaction) {
		int n = satisfaction.length;
		Arrays.sort(satisfaction);
		int res = 0;
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i][j] = dp[i - 1][j - 1] + satisfaction[i - 1] * j;
				if (j < i) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
				}
				res = Math.max(res, dp[i][j]);
			}
		}
		return res;
	}
}
// @lc code=end



/*
// @lcpr case=start
// [-1,-8,0,5,-9]\n
// @lcpr case=end

// @lcpr case=start
// [4,3,2]\n
// @lcpr case=end

// @lcpr case=start
// [-1,-4,-5]\n
// @lcpr case=end

 */

