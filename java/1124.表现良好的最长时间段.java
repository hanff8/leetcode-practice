import java.util.ArrayDeque;

/*
 * @lc app=leetcode.cn id=1124 lang=java
 * @lcpr version=21505
 *
 * [1124] 表现良好的最长时间段
 */

// @lc code=start
class Solution {
    public int longestWPI(int[] hours) {
        // 1. 单调栈
        // int ans = 0, n = hours.length;
        // int[] s = new int[n + 1];
        // var st = new ArrayDeque<Integer>();
        // st.push(0);
        // for (int i = 1; i <= n; i++) {
        // s[i] = s[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
        // if (s[i] < s[st.peek()])
        // st.push(i);
        // }
        // for (int i = n; i > 0; i--) {
        // while (!st.isEmpty() && s[i] > s[st.peek()]) {
        // ans = Math.max(ans, i - st.pop());
        // }
        // }
        // return ans;
        int n = hours.length, ans = 0, s = 0;
        var pos = new int[n + 2]; // 记录前缀和首次出现的位置
        for (int i = 1; i <= n; ++i) {
            s -= hours[i - 1] > 8 ? 1 : -1; // 取反，改为减法
            System.out.println(s);
            if (s < 0)
                ans = i;
            else {
                if (pos[s + 1] > 0)
                    ans = Math.max(ans, i - pos[s + 1]);
                if (pos[s] == 0)
                    pos[s] = i;
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
 * // [9,9,6,0,6,6,9]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [6,6,6]\n
 * // @lcpr case=end
 * 
 */
