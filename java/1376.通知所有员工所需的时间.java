/*
 * @lc app=leetcode.cn id=1376 lang=java
 * 
 * @lcpr version=21907
 *
 * [1376] 通知所有员工所需的时间
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public int dfs(List<Integer>[] list, int[] informTime, int header) {
        int maxPathSum = 0;
        for (int y : list[header]) {
            maxPathSum = Math.max(maxPathSum, dfs(list, informTime, y));
        }
        return maxPathSum + informTime[header];
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] list = new ArrayList[n];
        // Arrays.setAll(list, e -> new ArrayList<>());
        Arrays.fill(list, new ArrayList<>());
        // 建立示例中的树
        for (int i = 0; i < n; i++) {
            if (manager[i] >= 0) {
                list[manager[i]].add(i);
            }
        }
        return dfs(list, informTime, headID);
    }
}
// @lc code=end



/*
 * // @lcpr case=start // 1\n0\n[-1]\n[0]\n // @lcpr case=end
 * 
 * // @lcpr case=start // 6\n2\n[2,2,-1,2,2,2]\n[0,0,1,0,0,0]\n // @lcpr case=end
 * 
 */

