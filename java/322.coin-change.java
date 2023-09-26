/*
 * @lc app=leetcode.cn id=322 lang=java
 * 
 * @lcpr version=21914
 *
 * [322] 零钱兑换
 */

// @lc code=start

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

class Solution {
	public int coinChange(int[] coins, int amount) {
		if (amount < 1) {
			return 0;
		}
		return coinChange(coins, amount, new int[amount + 1]);
	}

	// count 记忆数组
	private int coinChange(int[] coins, int rem, int[] count) {
		// 分配失败
		if (rem < 0) {
			return -1;
		}
		// 恰好达到目标
		if (rem == 0) {
			return 0;
		}
		// 搜到cache中已经存在的，直接返回
		if (count[rem] != 0) {
			return count[rem];
		}
		int min = Integer.MAX_VALUE;
		for (int coin : coins) {
			// 开始深搜
			int res = coinChange(coins, rem - coin, count);
			// 如果返回的值 在分配中或者已经分配完成
			if (res >= 0 && res < min) {
				min = 1 + res;
			}
		}
		// 将结果值记录到数组中
		count[rem] = (min == Integer.MAX_VALUE) ? -1 : min;
		return count[rem];
	}
}
// @lc code=end



/*
// @lcpr case=start
// [1, 2, 5]\n11\n
// @lcpr case=end

// @lcpr case=start
// [2]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1]\n0\n
// @lcpr case=end

 */

