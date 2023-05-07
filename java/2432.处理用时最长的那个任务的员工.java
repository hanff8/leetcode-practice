/*
 * @lc app=leetcode.cn id=2432 lang=java
 * 
 * @lcpr version=21907
 *
 * [2432] 处理用时最长的那个任务的员工
 */

// @lc code=start
class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int prev = -1;
        int nums = logs.length;
        int max = 0, id = 0;
        for (int i = 0; i < nums; ++i) {
            if (prev != -1) {
                int tmp = logs[i][1];
                logs[i][1] -= prev;
                prev = tmp;
            } else {
                prev = logs[i][1];
            }
            if (max < logs[i][1]) {
                max = logs[i][1];
                id = logs[i][0];
            }
            if (max == logs[i][1]) {
                id = Math.min(id, logs[i][0]);
            }
        }
        return id;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // 10\n[[0,3],[2,5],[0,9],[1,15]]\n // @lcpr case=end
 * 
 * // @lcpr case=start // 26\n[[1,1],[3,7],[2,12],[7,17]]\n // @lcpr case=end
 * 
 * // @lcpr case=start // 2\n[[0,10],[1,20]]\n // @lcpr case=end
 * 
 */

