/*
 * @lc app=leetcode.cn id=1109 lang=java
 * 
 * @lcpr version=21917
 *
 * [1109] 航班预订统计
 */

// @lc code=start

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
	public int[] corpFlightBookings(int[][] bookings, int n) {
		int[] d = new int[n + 1];
		for (int[] b : bookings) {
			int first = b[0], last = b[1], seats = b[2];
			d[first] += seats;
			if (last + 1 < n + 1) {
				d[last + 1] -= seats;
			}
		}
		for (int i = 1; i < d.length; i++) {
			d[i] += d[i - 1];
		}
		int[] res = IntStream.range(1, n + 1).map(i -> d[i]).toArray();
		return res;
	}
}
// @lc code=end



/*
// @lcpr case=start
// [[1,2,10],[2,3,20],[2,5,25]]\n5\n
// @lcpr case=end

// @lcpr case=start
// [[1,2,10],[2,2,15]]\n2\n
// @lcpr case=end

 */

