/*
 * @lc app=leetcode.cn id=2381 lang=java
 * 
 * @lcpr version=21917
 *
 * [2381] 字母移位 II
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.ArrayDeque;
import java.util.Deque;

// @lc code=start
class Solution {
	public String shiftingLetters(String s, int[][] shifts) {
		int[] d = new int[s.length() + 1];
		char[] ch = s.toCharArray();
		for (int[] shi : shifts) {
			int from = shi[0], to = shi[1], dir = shi[2];
			d[from] += dir == 1 ? 1 : -1;
			d[to + 1] -= dir == 1 ? 1 : -1;
		}
		for (int i = 1; i < d.length; i++) {
			d[i] += d[i - 1];
		}
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			ch[i] = (char) ((c - 'a' + (d[i] % 26) + 26) % 26 + 'a');
		}

		return String.valueOf(ch);
	}
}
// @lc code=end



/*
// @lcpr case=start
// "abc"\n[[0,1,0],[1,2,1],[0,2,1]]\n
// @lcpr case=end

// @lcpr case=start
// "dztz"\n[[0,0,0],[1,1,1]]\n
// @lcpr case=end

 */

