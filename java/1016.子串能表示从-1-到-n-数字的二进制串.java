/*
 * @lc app=leetcode.cn id=1016 lang=java
 * 
 * @lcpr version=21907
 *
 * [1016] 子串能表示从 1 到 N 数字的二进制串
 */

// @lc code=start
class Solution {
    public boolean queryString(String s, int n) {
        HashSet<Integer> set = new HashSet<>();
        var chs = s.toCharArray();
        for (int i = 0, m = chs.length; i < m; ++i) {
            int x = chs[i] - '0';
            if (x == 0)
                continue;
            for (int j = i + 1; x <= n; j++) {
                set.add(x);
                if (j == m)
                    break;
                x = (x << 1) | (chs[j] - '0');
            }
        }
        return set.size() == n;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // "0110"\n3\n // @lcpr case=end
 * 
 * // @lcpr case=start // "0110"\n4\n // @lcpr case=end
 * 
 */

