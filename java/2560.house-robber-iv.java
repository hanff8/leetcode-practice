/*
 * @lc app=leetcode.cn id=2560 lang=java
 * 
 * @lcpr version=21914
 *
 * [2560] 打家劫舍 IV
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
	public int minCapability(int[] nums, int k) {
		int lowest = Arrays.stream(nums).min().getAsInt();
		int hightest = Arrays.stream(nums).max().getAsInt();
		while (lowest <= hightest) {
			int mid = (lowest + hightest) / 2;

			if (check1(nums, mid, k)) {
				hightest = mid - 1;
			} else {
				lowest = mid + 1;
			}
		}
		return lowest;
	}

	private boolean check(int[] nums, int mx, int k) {
		int f0 = 0, f1 = 0;
		for (int x : nums) {
			if (x > mx) {
				/**
				 * f0 = f1 相当于 int tmp = f1; f1 = f1; f0 = tmp;
				 * 
				 * 用「选或不选」来分类讨论：
				 * 
				 * 不选nums[i]: f[i] = f[i-1];
				 * 
				 * 选nums[i],前提是nums[i]<=mx: f[i] = f[i-2]+1;
				 * 
				 */
				f0 = f1;
			} else {
				int tmp = f1;
				f1 = Math.max(f1, f0 + 1);
				f0 = tmp;
			}

		}
		return f1 >= k;
	}

	// 贪心 能偷就偷,偷完跳过下一个房子
	private boolean check1(int[] nums, int mx, int k) {
		int cnt = 0, n = nums.length;
		for (int i = 0; i < n; i++) {
			if (nums[i] <= mx) {
				++cnt;
				++i;
			}
		}
		return cnt >= k;
	}

}
// @lc code=end



/*
// @lcpr case=start
// [2,3,5,9]\n2\n
// @lcpr case=end

// @lcpr case=start
// [2,7,9,3,1]\n2\n
// @lcpr case=end

 */

