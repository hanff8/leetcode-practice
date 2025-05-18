/*
 * @lc app=leetcode.cn id=908 lang=java
 * 
 * @lcpr version=30204
 *
 * [908] 最小差值 I
 */


// @lcpr-template-start
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayDeque;
import java.util.Deque;

// @lcpr-template-end
// @lc code=start
class Solution {
	public int smallestRangeI(int[] nums, int k) {
		Arrays.sort(nums);
		int n = nums.length;
		int maxNum = Arrays.stream(nums).max().getAsInt();
		int minNum = Arrays.stream(nums).min().getAsInt();
		return maxNum - minNum <= k * 2 ? 0 : maxNum - minNum - 2 * k;
	}
}
// @lc code=end



/*
// @lcpr case=start
// [1]\n0\n
// @lcpr case=end

// @lcpr case=start
// [0,10]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1,3,6]\n3\n
// @lcpr case=end

 */

