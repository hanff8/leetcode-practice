/*
 * @lc app=leetcode.cn id=1465 lang=java
 * 
 * @lcpr version=30102
 *
 * [1465] 切割后面积最大的蛋糕
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
	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);
		return (int) (calMax(verticalCuts, w) * calMax(horizontalCuts, h) % 1000000007);
	}

	public long calMax(int[] arr, int boarder) {
		int res = 0, pre = 0;
		for (int i = 0; i < arr.length; i++) {
			res = Math.max(arr[i] - pre, res);
			pre = arr[i];
		}
		return Math.max(res, boarder - pre);
	}
}
// @lc code=end



/*
// @lcpr case=start
// 5\n4\n[1,2,4]\n[1,3]\n
// @lcpr case=end

// @lcpr case=start
// 5\n4\n[3,1]\n[1]\n
// @lcpr case=end

// @lcpr case=start
// 5\n4\n[3]\n[3]\n
// @lcpr case=end

 */

