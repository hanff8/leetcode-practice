/*
 * @lc app=leetcode.cn id=2520 lang=java
 * 
 * @lcpr version=30102
 *
 * [2520] 统计能整除数字的位数
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
	public int countDigits(int num) {
		int t = num;
		int res = 0;
		while (t != 0) {
			if (num % (t % 10) == 0)
				res++;
			t /= 10;
		}
		return res;
	}
}
// @lc code=end



/*
// @lcpr case=start
// 7\n
// @lcpr case=end

// @lcpr case=start
// 121\n
// @lcpr case=end

// @lcpr case=start
// 1248\n
// @lcpr case=end

 */

