/*
 * @lc app=leetcode.cn id=1494 lang=java
 * 
 * @lcpr version=21909
 *
 * [1494] 并行课程 II
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    private int[] pre1, memo;
    private int k, u;

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        this.k = k;
        pre1 = new int[n];
        for (var r : relations) {
            //pre数组的 index 存放的是课程编号，val值表示这个index表示的课程的先修课的编号
            //val 值使用使用二进制进行压缩
            pre1[r[1] - 1] |= 1 << (r[0] - 1);
            System.out.println(Integer.toBinaryString(pre1[r[1] - 1]));
        }
        //假设 n = 4 则 u： 1111
        u = (1 << n) - 1;
        memo = new int[1 << n];
        Arrays.fill(memo, -1);
        return dfs(u);
    }

    private int dfs(int i) {
        if (i == 0)
            return 0;//空集
        if (memo[i] != -1)
            return memo[i];
        int i1 = 0, ci = u ^ i;
        for (int j = 0; j < pre1.length; j++) {
            if ((i >> j & 1) > 0 && (pre1[j] | ci) == ci)
                i1 |= 1 << j;
        }
        if (Integer.bitCount(i1) <= k) {
            return memo[i] = dfs(i ^ i1) + 1;
        }
        int res = Integer.MAX_VALUE;
        for (int j = i1; j > 0; j = (j - 1) & i1) {
            if (Integer.bitCount(j) <= k) {
                res = Math.min(res, dfs(i ^ j) + 1);
            }
        }
        return memo[i] = res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 4\n[[2,1],[3,1],[1,4]]\n2\n
// @lcpr case=end

// @lcpr case=start
// 5\n[[2,1],[3,1],[4,1],[1,5]]\n2\n
// @lcpr case=end

// @lcpr case=start
// 11\n[]\n2\n
// @lcpr case=end

 */

