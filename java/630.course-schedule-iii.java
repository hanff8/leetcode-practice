/*
 * @lc app=leetcode.cn id=630 lang=java
 * 
 * @lcpr version=21913
 *
 * [630] 课程表 III
 */
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

// @lc code=start
class Solution {
	/*
	 * 对于两门课(t1,d1)和(t2,d2)，如果后者的关闭时间较晚，即 d1≤d2
	，那么我们先学习前者，再学习后者，总是最优的。
	 */
	public int scheduleCourse(int[][] courses) {
		Arrays.sort(courses, (a, b) -> a[1] - b[1]);
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		int total = 0;

		for (int[] course : courses) {
			int ti = course[0], di = course[1];
			if (total + ti <= di) {
				total += ti;
				pq.offer(ti);
			} else if (!pq.isEmpty() && pq.peek() > ti) {
				total -= pq.poll() - ti;
				pq.offer(ti);
			}
		}
		return pq.size();
	}
}
// @lc code=end



/*
// @lcpr case=start
// [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,2]]\n
// @lcpr case=end

// @lcpr case=start
// [[3,2],[4,3]]\n
// @lcpr case=end

 */

