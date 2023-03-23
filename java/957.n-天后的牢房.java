import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=957 lang=java
 * @lcpr version=21801
 *
 * [957] N 天后的牢房
 */

// @lc code=start
class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<Integer, Integer> seen = new HashMap<>();
        int state = 0;
        for (int i = 0; i < 8; i++) {
            if (cells[i] > 0)
                state ^= 1 << i;
        }
        while (n > 0) {
            if (seen.containsKey(state)) {
                n %= seen.get(state) - n;
            }
            seen.put(state, n);
            if (n >= 1) {
                n--;
                state = nextDay(state);
            }
        }
        int[] ans = new int[8];
        for (int i = 0; i < 8; i++) {
            if (((state >> i) & 1) > 0) {
                ans[i] = 1;
            }
        }
        return ans;
    }

    public int nextDay(int state) {
        int ans = 0;
        for (int i = 1; i <= 6; i++) {
            if (((state >> (i - 1)) & 1) == ((state >> (i + 1)) & 1)) {
                ans ^= 1 << i;
            }
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
 * // [0,1,0,1,1,0,0,1]\n7\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,0,0,1,0,0,1,0]\n1000000000\n
 * // @lcpr case=end
 * 
 */
