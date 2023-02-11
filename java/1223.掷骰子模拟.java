/*
 * @lc app=leetcode.cn id=1223 lang=java
 * @lcpr version=21504
 *
 * [1223] 掷骰子模拟
 */

// @lc code=start
class Solution {
    static final int MOD = 1000000007;

    public int dieSimulator(int n, int[] rollMax) {
        int[][][] d = new int[2][6][16];
        for (int j = 0; j < 6; j++) {
            d[1][j][1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            int t = i & 1;
            for (int j = 0; j < 6; j++) {
                Arrays.fill(d[t][j], 0);
            }
            for (int j = 0; j < 6; j++) {
                for (int k = 1; k <= rollMax[j]; k++) {
                    for (int p = 0; p < 6; p++) {
                        if (p != j) {
                            d[t][p][1] = (d[t][p][1] + d[t ^ 1][j][k]) % MOD;
                        } else if (k + 1 <= rollMax[j]) {
                            d[t][p][k + 1] = (d[t][p][k + 1] + d[t ^ 1][j][k]) % MOD;
                        }
                    }
                }
            }
        }

        int res = 0;
        for (int j = 0; j < 6; j++) {
            for (int k = 1; k <= rollMax[j]; k++) {
                res = (res + d[n & 1][j][k]) % MOD;
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
 * // @lcpr case=start
 * // 2\n[1,1,2,2,2,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 2\n[1,1,1,1,1,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 3\n[1,1,1,2,2,3]\n
 * // @lcpr case=end
 * 
 */
