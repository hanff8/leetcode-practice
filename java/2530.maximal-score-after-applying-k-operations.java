/*
 * @lc app=leetcode.cn id=2530 lang=java
 * 
 * @lcpr version=30102
 *
 * [2530] 执行 K 次操作后的最大分数
 */


// @lcpr-template-start
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayDeque;
import java.util.Deque;

// @lcpr-template-end
// @lc code=start
class Solution {
	public long maxKelements(int[] nums, int k) {
		PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> b - a);
		for (int num : nums) {
			que.offer(num);
		}
		long ans = 0;
		for (int i = 0; i < k; i++) {
			int x = que.poll();
			ans += x;
			que.offer((x + 2) / 3);
		}
		return ans;
	}
}
// @lc code=end



/*
// @lcpr case=start
// [10,10,10,10,10]\n5\n
// @lcpr case=end

// @lcpr case=start
// [1,10,3,3,3]\n3\n
// @lcpr case=end

 */

