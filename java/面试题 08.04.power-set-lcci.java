/*
 * @lc app=leetcode.cn id=面试题 08.04 lang=java
 * 
 * @lcpr version=21917
 *
 * [面试题 08.04] 幂集
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

import java.util.ArrayList;

class Solution {
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> path = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {
		dfs(0, nums);
		// backT(0, nums);
		return res;
	}

	private void backT(int cur, int[] nums) {
		res.add(new ArrayList<>(path));
		if (cur == nums.length) {
			return;
		}
		for (int i = cur; i < nums.length; i++) {

			path.add(nums[i]);
			backT(i + 1, nums);
			path.remove(path.size() - 1);
			// backT(i + 1, nums);
		}

	}

	private void dfs(int cur, int[] nums) {
		if (cur == nums.length) {
			res.add(new ArrayList<>(path));
			return;
		}
		dfs(cur + 1, nums);
		path.add(nums[cur]);
		dfs(cur + 1, nums);
		path.remove(path.size() - 1);
	}
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

 */

