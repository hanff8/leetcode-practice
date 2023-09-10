/*
 * @lc app=leetcode.cn id=2594 lang=java
 * 
 * @lcpr version=21913
 *
 * [2594] 修车的最少时间
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

import java.util.stream.IntStream;

class Solution {
	public long repairCars(int[] ranks, int cars) {
		long left = 1l, right = 1l * ranks[0] * cars * cars;
		while (left < right) {
			long mid = (left + right) / 2;
			if (check(ranks, cars, mid)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	private boolean check(int[] ranks, int cars, long m) {
		long cnt = 0;
		for (int x : ranks) {
			cnt += (long) Math.sqrt(m / x);
		}
		return cnt >= cars;
	}
}
// @lc code=end



/*
// @lcpr case=start
// [4,2,3,1]\n10\n
// @lcpr case=end

// @lcpr case=start
// [5,1,8]\n6\n
// @lcpr case=end

 */

