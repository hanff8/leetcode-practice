/*
 * @lc app=leetcode.cn id=1155 lang=java
 * 
 * @lcpr version=30102
 *
 * [1155] 掷骰子等于目标和的方法数
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
	private static final int MOD = 1_000_000_007;

	public int numRollsToTarget(int n, int k, int target) {
		if (target < n || target > n * k) {
			return 0;
		}
		int[][] memo = new int[n + 1][target - n + 1];
		for (int[] m : memo) {
			Arrays.fill(m, -1); // -1 表示没有计算过
		}
		return dfs(n, target - n, k, memo);
	}

	public int dfs(int i, int j, int k, int[][] memo) {
		if (i == 0) {
			return j == 0 ? 1 : 0;
		}
		if (memo[i][j] != -1) {
			return memo[i][j];
		}
		int res = 0;
		for (int x = 0; x < k && x <= j; x++) {
			res = (res + dfs(i - 1, j - x, k, memo)) % MOD;
		}
		return memo[i][j] = res;
	}
}
// @lc code=end



/*
// @lcpr case=start
// 1\n6\n3\n
// @lcpr case=end

// @lcpr case=start
// 2\n6\n7\n
// @lcpr case=end

// @lcpr case=start
// 30\n30\n500\n
// @lcpr case=end

 */

