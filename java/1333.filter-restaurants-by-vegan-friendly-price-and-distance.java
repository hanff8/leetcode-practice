/*
 * @lc app=leetcode.cn id=1333 lang=java
 * 
 * @lcpr version=21917
 *
 * [1333] 餐厅过滤器
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.ArrayDeque;
import java.util.Deque;
// @lc code=start

class Solution {
	public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice,
			int maxDistance) {
		List<int[]> res = new ArrayList<>();

		int n = restaurants.length;
		for (int i = 0; i < n; i++) {
			if ((restaurants[i][2] == 1 || veganFriendly == 0) && restaurants[i][3] <= maxPrice
					&& restaurants[i][4] <= maxDistance) {
				res.add(restaurants[i]);
			}
		}
		List<Integer> collect = res.stream().sorted((a, b) -> {
			if (a[1] == b[1]) {
				return b[0] - a[0];
			} else {
				return b[1] - a[1];
			}
		}).mapToInt((a) -> a[0]).boxed().collect(Collectors.toList());
		return collect;
	}
}
// @lc code=end



/*
// @lcpr case=start
// [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]]\n1\n50\n10\n
// @lcpr case=end

// @lcpr case=start
// [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]]\n0\n50\n10\n
// @lcpr case=end

// @lcpr case=start
// [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]]\n0\n30\n3\n
// @lcpr case=end

 */

