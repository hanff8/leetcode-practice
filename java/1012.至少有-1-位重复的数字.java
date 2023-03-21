import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1012 lang=java
 * 
 * @lcpr version=21801
 *
 * [1012] 至少有 1 位重复的数字
 */

// @lc code=start
class Solution {
    char s[];
    int memo[][];

    public int numDupDigitsAtMostN(int n) {
        s = Integer.toString(n).toCharArray();
        int m = s.length;
        memo = new int[m][1 << 10];
        for (int i = 0; i < m; i++)
            Arrays.fill(memo[i], -1); // -1 表示没有计算过
        return n - f(0, 0, true, false);
    }

    int f(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum ? 1 : 0; // isNum 为True表示得到了一个合法数字
        }
        if (!isLimit && isNum && memo[i][mask] != -1) {
            return memo[i][mask];
        }
        int res = 0;
        if (!isNum) {
            res = f(i + 1, mask, false, false);
        }
        int up = isLimit ? s[i] - '0' : 9; // 如果前面填的数字都和 n 的一样，那么这一位至多填数字 s[i]（否则就超过 n 啦）
        for (int d = isNum ? 0 : 1; d <= up; ++d) {
            if ((mask >> d & 1) == 0) {
                res += f(i + 1, mask | (1 << d), isLimit && d == up, true);
            }
        }
        if (!isLimit && isNum) {
            memo[i][mask] = res;
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
 * // @lcpr case=start // 20\n // @lcpr case=end
 * 
 * // @lcpr case=start // 100\n // @lcpr case=end
 * 
 * // @lcpr case=start // 1000\n // @lcpr case=end
 * 
 */


