/*
 * @lc app=leetcode.cn id=1726 lang=java
 * 
 * @lcpr version=30102
 *
 * [1726] 同积元组
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
	public int tupleSameProduct(int[] nums) {
		int n = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int key = nums[i] * nums[j];
				map.put(key, map.getOrDefault(key, 0) + 1);
			}
		}
		int ans = 0;
		for (Integer v : map.values()) {
			// 每找到一对，都有2*2四种组合
			ans += v * (v - 1) * 4;
		}
		return ans;
	}

}
// @lc code=end



/*
// @lcpr case=start
// [2,3,4,6]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,4,5,10]\n
// @lcpr case=end

 */

