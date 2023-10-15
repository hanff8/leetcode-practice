/*
 * @lc app=leetcode.cn id=1094 lang=java
 * 
 * @lcpr version=21917
 *
 * [1094] 拼车
 */

// @lc code=start

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

class Solution {
	public boolean carPooling(int[][] trips, int capacity) {

		// return solution1(trips, capacity);
		return solution2(trips, capacity);
	}

	private boolean solution2(int[][] trips, int capacity) {
		Map<Integer, Integer> d = new TreeMap<>();
		for (int[] t : trips) {
			int num = t[0], from = t[1], to = t[2];
			// d.merge(from, num, Integer::sum);
			// d.merge(to, -num, Integer::sum);
			d.put(from, d.getOrDefault(from, 0) + num);
			d.put(to, d.getOrDefault(to, 0) - num);
		}
		System.out.println(d);
		int s = 0;
		for (int v : d.values()) {
			s += v;
			if (s > capacity)
				return false;
		}
		return true;

	}

	private boolean solution1(int[][] trips, int capacity) {
		int[] arr = new int[10001];
		for (int[] t : trips) {
			int left = t[1], right = t[2];
			arr[left] += t[0];
			arr[right] -= t[0];
		}
		int s = 0;
		for (int i = 0; i < arr.length; i++) {
			s += arr[i];
			if (s > capacity)
				return false;
		}
		return true;
	}
}
// @lc code=end



/*
// @lcpr case=start
// [[2,1,5],[3,3,7]]\n4\n
// @lcpr case=end

// @lcpr case=start
// [[2,1,5],[3,3,7]]\n5\n
// @lcpr case=end

 */

