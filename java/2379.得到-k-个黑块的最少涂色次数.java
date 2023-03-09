/*
 * @lc app=leetcode.cn id=2379 lang=java
 * @lcpr version=21801
 *
 * [2379] 得到 K 个黑块的最少涂色次数
 */

// @lc code=start
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int curretNum = 0;
        int n = blocks.length();
        int ans = n;
        for (int i = 0; i < n - k + 1; i++) {
            int j = 0;
            curretNum = 0;
            while (j < k) {
                if (blocks.charAt(i + j) == 'B') {
                    ++curretNum;
                }
                ++j;
            }
            ans = Math.min(ans, k - curretNum);
        }
        return ans;
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end

/*
 * // @lcpr case=start
 * // "WBBWWBBWBW"\n7\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "WBWBBBW"\n2\n
 * // @lcpr case=end
 * 
 */
