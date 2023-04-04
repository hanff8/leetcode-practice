import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1641 lang=java
 * @lcpr version=21901
 *
 * [1641] 统计字典序元音字符串的数目
 */

// @lc code=start
class Solution {
    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return Arrays.stream(dp).sum();
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 1\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 33\n
 * // @lcpr case=end
 * 
 */
