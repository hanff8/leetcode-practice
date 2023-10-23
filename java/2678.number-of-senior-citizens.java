/*
 * @lc app=leetcode.cn id=2678 lang=java
 * 
 * @lcpr version=30102
 *
 * [2678] 老人的数目
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
	public int countSeniors(String[] details) {
		return (int) Arrays.stream(details).mapToInt(a -> Integer.parseInt(a.substring(11, 13)))
				.filter(a -> a > 60).count();
	}
}
// @lc code=end



/*
// @lcpr case=start
// ["7868190130M7522","5303914400F9211","9273338290F4010"]\n
// @lcpr case=end

// @lcpr case=start
// ["1313579440F2036","2921522980M5644"]\n
// @lcpr case=end

 */

