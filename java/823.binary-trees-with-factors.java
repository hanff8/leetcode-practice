/*
 * @lc app=leetcode.cn id=823 lang=java
 * 
 * @lcpr version=21913
 *
 * [823] 带因子的二叉树
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
	public int numFactoredBinaryTrees(int[] arr) {
		Arrays.sort(arr);
		int n = arr.length;
		long[] dp = new long[n];
		long res = 0, mod = 1000000007;
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
			for (int left = 0, right = i - 1; left <= right; left++) {
				while (right >= left && (long) arr[left] * arr[right] > arr[i]) {
					right--;
				}
				if (right >= left && (long) arr[left] * arr[right] == arr[i]) {
					if (right != left) {
						dp[i] = (dp[i] + dp[left] * dp[right] * 2) % mod;
					} else {
						dp[i] = (dp[i] + dp[left] * dp[right]) % mod;
					}
				}
			}
			res = (res + dp[i]) % mod;
		}
		System.out.println(Arrays.toString(dp));
		return (int) res;
	}
}
// @lc code=end



/*
// @lcpr case=start
// [2, 4]\n
// @lcpr case=end

// @lcpr case=start
// [2, 4, 5, 10]\n
// @lcpr case=end

 */

