/*
 * @lc app=leetcode.cn id=1263 lang=java
 * 
 * @lcpr version=21907
 *
 * [1263] 推箱子
 */

// @lc code=start

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int minPushBox(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int px = 0, py = 0, bx = 0, by = 0, tx = 0, ty = 0;

        // 找出 S B T 三个点的坐标
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    px = i;
                    py = j;
                }
                if (grid[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
                if (grid[i][j] == 'T') {
                    tx = i;
                    ty = j;
                }
            }
        }

        Deque<Node> queue = new LinkedList<>();
        boolean[][][][] visited = new boolean[m][n][m][n];
        visited[px][py][bx][by] = true;
        queue.offer(new Node(px, py, bx, by, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            // 如果box已经在目标位置上了，直接返回次数
            if (cur.bx == tx && cur.by == ty) {
                return cur.step;
            }
            // 四个方向依次尝试
            for (int[] dir : dirs) {
                // 更新尝试移动后的对应的 S(position) B(Box) 坐标
                int newPx = cur.px + dir[0], newPy = cur.py + dir[1], newBx = cur.bx,
                        newBy = cur.by, newStep = cur.step;
                // S 坐标与 B 坐标重合，则表示角色推动一次箱子，则对箱子的坐标进行一次更新，同时记录一次步数
                if (newPx == cur.bx && newPy == cur.by) {
                    newBx += dir[0];
                    newBy += dir[1];
                    newStep++;
                }
                // 遇到非法坐标，碰到墙壁(边界)，以及碰到尝试过的坐标组合(visited) 直接continue
                if (newPx < 0 || newPx == m || newPy < 0 || newPy == n || newBx < 0 || newBx == m
                        || newBy < 0 || newBy == n || grid[newPx][newPy] == '#'
                        || grid[newBx][newBy] == '#' || visited[newPx][newPy][newBx][newBy]) {
                    continue;
                }
                Node newNode = new Node(newPx, newPy, newBx, newBy, newStep);
                // 用于添加 Node 如果newStep== curStep表示
                // 角色S(Position)还没有碰到箱子，这里可以直接分支了（以实例一为例子，左移或上移动，newNode直接前插，下个while循环继续当前分支的内容；
                // 否则则表示推动了箱子，则尾插，不妨碍当前分支的搜索
                boolean dummy =
                        newStep == cur.step ? queue.offerFirst(newNode) : queue.offerLast(newNode);
                // 标记这一次的坐标组合为true
                visited[newPx][newPy][newBx][newBy] = true;
            }
        }
        return -1;
    }

    class Node {
        int px;
        int py;
        int bx;
        int by;
        int step;

        public Node(int px, int py, int bx, int by, int step) {
            this.px = px;
            this.py = py;
            this.bx = bx;
            this.by = by;
            this.step = step;
        }
    }
}
// @lc code=end



/*
 * // @lcpr case=start //
 * [["#","#","#","#","#","#"],["#","T","#","#","#","#"],["#",".",".","B",".","#"],["#",".","#","#",
 * ".","#"],["#",".",".",".","S","#"],["#","#","#","#","#","#"]]\n // @lcpr case=end
 * 
 * // @lcpr case=start //
 * [["#","#","#","#","#","#"],["#","T","#","#","#","#"],["#",".",".","B",".","#"],["#","#","#","#",
 * ".","#"],["#",".",".",".","S","#"],["#","#","#","#","#","#"]]\n // @lcpr case=end
 * 
 * // @lcpr case=start //
 * [["#","#","#","#","#","#"],["#","T",".",".","#","#"],["#",".","#","B",".","#"],["#",".",".",".",
 * ".","#"],["#",".",".",".","S","#"],["#","#","#","#","#","#"]]\n // @lcpr case=end
 * 
 */

