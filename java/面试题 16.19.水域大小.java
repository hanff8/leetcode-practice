/*
 * @lc app=leetcode.cn id=面试题 16.19 lang=java
 * 
 * @lcpr version=21909
 *
 * [面试题 16.19] 水域大小
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Deque;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import java.util.function.IntFunction;
import java.util.ArrayDeque;
// @lc code=start

import java.util.ArrayList;

class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    list.add(bfs(land, i, j));
                }
            }
        }
        int[] res = list.stream().mapToInt(Integer::intValue).sorted().toArray();
        return res;
    }

    private int bfs(int[][] land, int x, int y) {
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[] {x, y});
        land[x][y] = -1;
        int res = 0;
        while (!que.isEmpty()) {
            int[] pos = que.poll();
            int curX = pos[0], curY = pos[1];
            res++;
            for (int[] dir : dirs) {
                if (curX + dir[0] < 0 || curY + dir[1] < 0 || curX + dir[0] >= land.length
                        || curY + dir[1] >= land[0].length
                        || land[curX + dir[0]][curY + dir[1]] != 0) {
                    continue;
                }
                land[curX + dir[0]][curY + dir[1]] = -1;
                que.offer(new int[] {curX + dir[0], curY + dir[1]});
            }
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[0,2,1,0],[0,1,0,1],[1,1,0,1],[0,1,0,1]]\n
// @lcpr case=end

 */

