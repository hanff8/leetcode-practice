/*
 * @lc app=leetcode.cn id=1031 lang=java
 * 
 * @lcpr version=21907
 *
 * [1031] 两个非重叠子数组的最大和
 */

// @lc code=start
class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int maxSumA = 0, maxSumB = 0, res = 0;
        for (int i = firstLen + secondLen; i <= n; ++i) {
            maxSumA = Math.max(maxSumA,
                    prefixSum[i - secondLen] - prefixSum[i - secondLen - firstLen]);
            maxSumB = Math.max(maxSumB,
                    prefixSum[i - firstLen] - prefixSum[i - firstLen - secondLen]);
            res = Math.max(res, Math.max(maxSumA + prefixSum[i] - prefixSum[i - secondLen],
                    maxSumB + prefixSum[i] - prefixSum[i - firstLen]));
        }
        return res;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // [0,6,5,2,2,5,1,9,4]\n1\n2\n // @lcpr case=end
 * 
 * // @lcpr case=start // [3,8,1,3,2,1,8,9,0]\n3\n2\n // @lcpr case=end
 * 
 * // @lcpr case=start // [2,1,5,6,0,9,5,0,3,8]\n4\n3\n // @lcpr case=end
 * 
 */

