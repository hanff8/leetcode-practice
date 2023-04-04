/*
 * @lc app=leetcode.cn id=1638 lang=java
 * 
 * @lcpr version=21801
 *
 * [1638] 统计只差一个字符的子串数目
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s, String t) {

        int m = s.length(), n = t.length();
        int[][][] dp = new int[m][n][2];
        // // 初始化数组
        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < n; j++) {
        // dp[i][j][0] = 0;
        // dp[i][j][1] = 0;
        // }
        // }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j][0] += 1;
                    dp[i][j][0] += i > 0 && j > 0 ? dp[i - 1][j - 1][0] : 0;
                    dp[i][j][1] += i > 0 && j > 0 ? dp[i - 1][j - 1][1] : 0;
                } else {
                    dp[i][j][1] += 1;
                    dp[i][j][1] += i > 0 && j > 0 ? dp[i - 1][j - 1][0] : 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += dp[i][j][1];
            }
        }
        return res;

    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // "aba"\n"baba"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "ab"\n"bb"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "a"\n"a"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "abe"\n"bbc"\n // @lcpr case=end
 * 
 */


