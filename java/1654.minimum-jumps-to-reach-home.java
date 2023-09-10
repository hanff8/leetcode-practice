/*
 * @lc app=leetcode.cn id=1654 lang=java
 * 
 * @lcpr version=21913
 *
 * [1654] 到家的最少跳跃次数
 */

// @lc code=start
class Solution {
	public int minimumJumps(int[] forbidden, int a, int b, int x) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		Set<Integer> visited = new HashSet<Integer>();
		queue.offer(new int[] {0, 1, 0});
		visited.add(0);
		int lower = 0, upper = Math.max(Arrays.stream(forbidden).max().getAsInt() + a, x) + b;
		Set<Integer> forbiddenSet = new HashSet<Integer>();
		for (int position : forbidden) {
			forbiddenSet.add(position);
		}
		while (!queue.isEmpty()) {
			int[] arr = queue.poll();
			int position = arr[0], direction = arr[1], step = arr[2];
			if (position == x) {
				return step;
			}
			int nextPosition = position + a;
			int nextDirection = 1;
			if (lower <= nextPosition && nextPosition <= upper
					&& !visited.contains(nextPosition * nextDirection)
					&& !forbiddenSet.contains(nextPosition)) {
				visited.add(nextPosition * nextDirection);
				queue.offer(new int[] {nextPosition, nextDirection, step + 1});
			}
			if (direction == 1) {
				nextPosition = position - b;
				nextDirection = -1;
				if (lower <= nextPosition && nextPosition <= upper
						&& !visited.contains(nextPosition * nextDirection)
						&& !forbiddenSet.contains(nextPosition)) {
					visited.add(nextPosition * nextDirection);
					queue.offer(new int[] {nextPosition, nextDirection, step + 1});
				}
			}
		}
		return -1;

	}
}
// @lc code=end



/*
// @lcpr case=start
// [14,4,18,1,15]\n3\n15\n9\n
// @lcpr case=end

// @lcpr case=start
// [8,3,16,6,12,20]\n15\n13\n11\n
// @lcpr case=end

// @lcpr case=start
// [1,6,2,14,5,17,4]\n16\n9\n7\n
// @lcpr case=end

 */

