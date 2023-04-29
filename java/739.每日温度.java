import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=739 lang=java
 * 
 * @lcpr version=21906
 *
 * [739] 每日温度
 */

// @lc code=start
class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        // int n = temperatures.length;
        // int[] ans = new int[n];
        // int[] next = new int[101];
        // Arrays.fill(next, Integer.MAX_VALUE);
        // for (int i = n - 1; i >= 0; i--) {
        // int warmIndex = Integer.MAX_VALUE;
        // for (int t = temperatures[i] + 1; t <= 100; ++t) {
        // if (next[t] < warmIndex)
        // warmIndex = next[t];
        // }
        // if (warmIndex < Integer.MAX_VALUE) {
        // ans[i] = warmIndex - i;
        // }
        // next[temperatures[i]] = i;
        // }
        // return ans;

        // 单调栈
        int n = temperatures.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && temperatures[i] > temperatures[deque.peek()]) {
                int preIndex = deque.pop();
                ans[preIndex] = i - preIndex;
            }
            deque.push(i);
        }
        return ans;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // [73,74,75,71,69,72,76,73]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [30,40,50,60]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [30,60,90]\n // @lcpr case=end
 * 
 */

