/*
 * @lc app=leetcode.cn id=647 lang=java
 * 
 * @lcpr version=21917
 *
 * [647] 回文子串
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

	public int countSubstrings(String s) {
		// return solution1(s);
		return solution2(s);
	}

	private int solution2(String s) {
		int n = s.length();
		int cnt = 0;
		boolean[][] dp = new boolean[n][n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				// 当前两个字符是相等的，且，这两个字符之间的串dp[i+1][j-1]是回文的那么dp[i][j]就是回文的
				if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
					dp[i][j] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}

	private int solution1(String s) {
		int n = s.length(), ans = 0;
		for (int i = 0; i < 2 * n - 1; i++) {
			int l = i / 2, r = i / 2 + i % 2;
			while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
				--l;
				++r;
				++ans;
			}
		}
		return ans;
	}

}
// @lc code=end



/*
// @lcpr case=start
// "abc"\n
// @lcpr case=end

// @lcpr case=start
// "aaa"\n
// @lcpr case=end

 */

