import java.util.ArrayDeque;

/*
 * @lc app=leetcode.cn id=962 lang=java
 * @lcpr version=21505
 *
 * [962] 最大宽度坡
 */

// @lc code=start
class Solution {
    public int maxWidthRamp(int[] nums) {
        int ans = 0, n = nums.length;
        // int[] s = new int[n + 1];
        var st = new ArrayDeque<Integer>();
        st.push(0);
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[st.peek()]) {
                st.push(i);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] >= nums[st.peek()]) {
                ans = Math.max(ans, i - st.pop());
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
 * //
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * //
 * // @lcpr case=end
 * 
 */
