/*
 * @lc app=leetcode.cn id=1802 lang=java
 * @lcpr version=21105
 *
 * [1802] 有界数组中指定下标处的最大值
 */

// @lc code=start
class Solution {
    // // 二分搜索
    // public int maxValue(int n, int index, int maxSum) {
    // int lCount = index, rCount = n - 1 - index;
    // int l = 1, r = maxSum;
    // while (l <= r) {
    // int m = (l + r) / 2;
    // long sum = m + helper(m, lCount) + helper(m, rCount);
    // if (sum > maxSum)
    // r = --m;
    // else
    // l = ++m;
    // }
    // return l - 1;
    // }

    // // 求山峰一侧的元素的和，max为山峰大小，k为某一侧的元素数量
    // private long helper(int max, int k) {
    // if (max > k)
    // return (long) k * (2 * max - 1 - k) / 2;
    // else
    // return (long) (max - 3) * max / 2 + k + 1;
    // }

    public int maxValue(int n, int index, int maxSum) {
        for (int ret = maxSum; ret > 0; --ret) {
            long sum = ret;
            for (int i = index + 1; i < n; i++) {
                sum += Math.max(ret - i + index, 1);
            }
            for (int i = index - 1; i >= 0; i--) {
                sum += Math.max(ret - index + i, 1);
            }
            if (sum <= maxSum) {
                return ret;
            }

        }
        return -1;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 4\n2\n6\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 6\n1\n10\n
 * // @lcpr case=end
 * 
 */
