//一个下标从 0 开始的数组的 交替和 定义为 偶数 下标处元素之 和 减去 奇数 下标处元素之 和 。 
//
// 
// 比方说，数组 [4,2,5,3] 的交替和为 (4 + 5) - (2 + 3) = 4 。 
// 
//
// 给你一个数组 nums ，请你返回 nums 中任意子序列的 最大交替和 （子序列的下标 重新 从 0 开始编号）。 
//
// 
// 
//
// 一个数组的 子序列 是从原数组中删除一些元素后（也可能一个也不删除）剩余元素不改变顺序组成的数组。比方说，[2,7,4] 是 [4,2,3,7,2,1,4
//] 的一个子序列（加粗元素），但是 [2,4,2] 不是。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,2,5,3]
//输出：7
//解释：最优子序列为 [4,2,5] ，交替和为 (4 + 5) - 2 = 7 。
// 
//
// 示例 2： 
//
// 输入：nums = [5,6,7,8]
//输出：8
//解释：最优子序列为 [8] ，交替和为 8 。
// 
//
// 示例 3： 
//
// 输入：nums = [6,2,1,2,4,5]
//输出：10
//解释：最优子序列为 [6,1,5] ，交替和为 (6 + 5) - 1 = 10 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 动态规划 👍 175 👎 0


package leetcode.editor.cn;

public class MaximumAlternatingSubsequenceSum {
    public static void main(String[] args) {
        Solution solution = new MaximumAlternatingSubsequenceSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxAlternatingSum(int[] nums) {
            int n = nums.length;
            int[][] dp = new int[n + 1][2];
            dp[0][0] = 0;
            dp[0][1] = Integer.MIN_VALUE/2;
            long f1 = 0,f2 = Integer.MIN_VALUE/2;
            for (int i = 0; i < n; i++) {
//                dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] - nums[i]);
//                dp[i + 1][1] = Math.max(dp[i][1], dp[i][0] + nums[i]);
                long newF = Math.max(f1,f2-nums[i]);
                f2 = Math.max(f2,f1+nums[i]);
                f1 = newF;
            }
            return f2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
