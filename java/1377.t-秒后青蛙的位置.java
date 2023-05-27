/*
 * @lc app=leetcode.cn id=1377 lang=java
 * 
 * @lcpr version=21908
 *
 * [1377] T 秒后青蛙的位置
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayDeque;

// @lc code=start
class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<Integer>[] g = new ArrayList[n + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        g[1].add(0); // 减少额外判断的小技巧
        for (var e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x); // 建树
        }
        long prod = dfs(g, target, 1, 0, t);
        return prod != 0 ? 1.0 / prod : 0;
    }

    // leftT 表示剩余的时间
    private long dfs(List<Integer>[] g, int target, int x, int fa, int leftT) {
        // t 秒后必须在 target（恰好到达，或者 target 是叶子停在原地）
        if (leftT == 0)
            return x == target ? 1 : 0;
        if (x == target)
            return g[x].size() == 1 ? 1 : 0;
        for (int y : g[x]) { // 遍历 x 的儿子 y
            if (y != fa) { // y 不能是父节点
                long prod = dfs(g, target, y, x, leftT - 1); // 寻找 target
                if (prod != 0)
                    return prod * (g[x].size() - 1); // 乘上儿子个数，并直接返回
            }
        }
        return 0; // 未找到 target
    }
}
// @lc code=end



/*
// @lcpr case=start
// 7\n[[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]]\n2\n4\n
// @lcpr case=end

// @lcpr case=start
// 7\n[[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]]\n1\n7\n
// @lcpr case=end

 */

