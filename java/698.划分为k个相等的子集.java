/*
 * @lc app=leetcode.cn id=698 lang=java
 * 
 * @lcpr version=21907
 *
 * [698] 划分为k个相等的子集
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    int[] bucket;


    public boolean dfs(int k, int cur, int[] nums) {
        if (cur < 0)
            return true;
        for (int i = 0; i < k; i++) {
            // 只放一个数桶就满了，或者还能放别的数字
            // 如果nums[i] 大于桶容量即平均数，则不可能实现直接返回false
            if (i > 0 && bucket[i] == bucket[i - 1])
                continue;
            if (bucket[i] == nums[cur] || bucket[i] - nums[cur] >= nums[0]) {

                // 回溯，放在当前桶不行的话，则放进下一个桶
                bucket[i] -= nums[cur];
                if (dfs(k, cur - 1, nums))
                    return true;
                bucket[i] += nums[cur];
            }
        }
        return false;
    }

    public boolean canPartitionKSubsets1(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0)
            return false;
        int ava = sum / k;
        Arrays.sort(nums);
        bucket = new int[k];
        Arrays.fill(bucket, ava);
        return dfs(k, nums.length - 1, nums);
    }

    int[] nums;
    int per, n;
    boolean[] dp;

    // 状态压缩+记忆化搜索
    public boolean dfs(int s, int prev) {
        if (s == 0)
            return true;
        if (!dp[s])
            return dp[s];
        dp[s] = false;
        for (int i = 0; i < n; ++i) {
            // 大于平均数，不可能达到结果
            if (nums[i] + prev > per) {
                break;
            }
            // 判断s的第i位是否为0
            if (((s >> i) & 1) != 0) {
                // 将第i位置为0 回溯 取余相当于查找一个新的子集
                if (dfs(s ^ (1 << i), (prev + nums[i]) % per))
                    return true;
            }
        }
        return false;
    }

    public boolean canPartitionKSubsets2(int[] nums, int k) {
        this.nums = nums;
        int all = Arrays.stream(nums).sum();
        if (all % k != 0)
            return false;
        per = all / k;
        Arrays.sort(nums);
        n = nums.length;
        if (nums[n - 1] > per) {
            return false;
        }
        dp = new boolean[1 << n];
        Arrays.fill(dp, true);
        // 初始化 假设n=8 (1<<n)-1: 011111111 共9位，后8为全为1 表示每一位都没访问过
        return dfs((1 << n) - 1, 0);
    }


    public boolean canPartitionKSubsets(int[] nums, int k) {
        int all = Arrays.stream(nums).sum();
        if (all % k != 0) {
            return false;
        }
        int per = all / k;
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n - 1] > per) {
            return false;
        }
        boolean[] dp = new boolean[1 << n];
        int[] curSum = new int[1 << n];
        dp[0] = true;
        for (int i = 0; i < 1 << n; i++) {
            if (!dp[i])
                continue;
            for (int j = 0; j < n; j++) {
                if (curSum[i] + nums[j] > per)
                    break;
                if (((i >> j) & 1) == 0) {
                    int next = i | (1 << j);
                    if (!dp[next]) {
                        curSum[next] = (curSum[i] + nums[j]) % per;
                        dp[next] = true;
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }

}
// @lc code=end



/*
 * // @lcpr case=start // [4, 3, 2, 3, 5, 2, 1]\n4\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1,2,3,4]\n3\n // @lcpr case=end
 * 
 */

