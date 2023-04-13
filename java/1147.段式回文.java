/*
 * @lc app=leetcode.cn id=1147 lang=java
 * 
 * @lcpr version=21905
 *
 * [1147] 段式回文
 */

// @lc code=start
class Solution {
    public int longestDecomposition(String s) {
        if (s.isEmpty())
            return 0;
        for (int i = 1, n = s.length(); i <= n / 2; ++i) // 枚举前后缀长度
            if (s.substring(0, i).equals(s.substring(n - i))) // 立刻分割
                return 2 + longestDecomposition(s.substring(i, n - i));
        return 1; // 无法分割

    }
}
// @lc code=end



/*
 * // @lcpr case=start // "ghiabcdefhelloadamhelloabcdefghi"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "merchant"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "antaprezatepzapreanta"\n // @lcpr case=end
 * 
 */


