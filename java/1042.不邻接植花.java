import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1042 lang=java
 * 
 * @lcpr version=21906
 *
 * [1042] 不邻接植花
 */

// @lc code=start
class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] list = new List[n];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        // 建立邻接表
        for (int[] path : paths) {
            list[path[0] - 1].add(path[1] - 1);
            list[path[1] - 1].add(path[0] - 1);
        }
        int[] ans = new int[n];
        for (int i = 0; i < ans.length; i++) {
            boolean[] visited = new boolean[5];

            // 将相邻的节点标记
            for (int val : list[i]) {
                visited[ans[val]] = true;
            }

            // 找到没有被标记的节点，该节点即为可以染色的节点
            for (int j = 1; j <= 4; j++) {
                if (!visited[j]) {
                    ans[i] = j;
                    break;
                }
            }
        }
        return ans;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // 3\n[[1,2],[2,3],[3,1]]\n // @lcpr case=end
 * 
 * // @lcpr case=start // 4\n[[1,2],[3,4]]\n // @lcpr case=end
 * 
 * // @lcpr case=start // 4\n[[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]\n // @lcpr case=end
 * 
 */

