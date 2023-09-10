/*
 * @lc app=leetcode.cn id=2605 lang=java
 * 
 * @lcpr version=21913
 *
 * [2605] 从两个数字数组里生成最小数字
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
class Solution {
	public int minNumber(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int res = Integer.MAX_VALUE;
		for (int a : nums1) {
			for (int b : nums2) {
				if (b > a) {
					break;
				}
				if (a == b) {
					res = Math.min(res, a);
				}
			}
		}

		return res == Integer.MAX_VALUE
				? Math.min(nums1[0] * 10 + nums2[0], nums2[0] * 10 + nums1[0])
				: res;
	}
}
// @lc code=end



/*
// @lcpr case=start
// [4,1,3]\n[5,7]\n
// @lcpr case=end

// @lcpr case=start
// [3,5,2,6]\n[3,1,7]\n
// @lcpr case=end

 */

