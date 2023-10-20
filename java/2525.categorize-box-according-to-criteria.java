/*
 * @lc app=leetcode.cn id=2525 lang=java
 * 
 * @lcpr version=30102
 *
 * [2525] 根据规则将箱子分类
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
	public String categorizeBox(int length, int width, int height, int mass) {
		boolean isHeavy = mass >= 100;
		boolean isBulky = (long) length * width * height >= 1_000_000_000
				|| Math.max(length, Math.max(width, height)) >= 10000;
		if (isBulky && isHeavy)
			return "Both";
		else if (isBulky)
			return "Bulky";
		else if (isHeavy)
			return "Heavy";
		else
			return "Neither";
	}
}
// @lc code=end



/*
// @lcpr case=start
// 1000\n35\n700\n300\n
// @lcpr case=end

// @lcpr case=start
// 200\n50\n800\n50\n
// @lcpr case=end

 */

