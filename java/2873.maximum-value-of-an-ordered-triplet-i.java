/*
 * @lc app=leetcode.cn id=2873 lang=java
 * 
 * @lcpr version=30204
 *
 * [2873] 有序三元组中的最大值 I
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
	public long maximumTripletValue(int[] nums) {
		int n = nums.length;
		int[] suffixMax = new int[n + 1];
		for (int i = n - 1; i > 0; i--) {
			suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
		}
		long ans = 0;
		int preMax = nums[0];
		for (int i = 1; i < n - 1; i++) {
			ans = Math.max(ans, (long) (preMax - nums[i]) * suffixMax[i + 1]);
			preMax = Math.max(preMax, nums[i]);
		}
		return ans;
	}
}
// @lc code=end



/*
// @lcpr case=start
// [12,6,1,2,7]\n
// @lcpr case=end

// @lcpr case=start
// [1,10,3,4,19]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

 */

