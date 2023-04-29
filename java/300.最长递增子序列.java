import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=300 lang=java
 * 
 * @lcpr version=21906
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        // Dynamic Programming
        // int n = nums.length;
        // int res = 0;
        // int[] dp = new int[n];
        // Arrays.fill(dp, 1);
        // for (int i = 0; i < n; ++i) {
        // for (int j = 0; j < i; ++j) {
        // if (nums[j] < nums[i])
        // dp[i] = Math.max(dp[i], dp[j] + 1);
        // }
        // res = Math.max(res, dp[i]);
        // }
        // System.out.println(Arrays.toString(dp));
        // return res;

        // Dynamic Programming+Dichotomy
        int n = nums.length;
        int[] tail = new int[n];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int mid = (i + j) / 2;
                if (tail[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            tail[i] = num;
            if (res == j)
                res++;
        }
        return res;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // [10,9,2,5,3,7,101,18]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [0,1,0,3,2,3]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [7,7,7,7,7,7,7]\n // @lcpr case=end
 * 
 */

