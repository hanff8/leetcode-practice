/*
 * @lc app=leetcode.cn id=LCP 41 lang=java
 * 
 * @lcpr version=21909
 *
 * [LCP 41] 黑白翻转棋
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
import java.util.ArrayDeque;
// @lc code=start


class Solution {
    int[][] dirs =
            new int[][] {{0, -1}, {0, 1}, {1, 0}, {-1, 0}, {-1, 1}, {-1, -1}, {1, 1}, {1, -1}};

    public int flipChess(String[] chessboard) {
        int res = 0;
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard[0].length(); j++) {
                if (chessboard[i].charAt(j) == '.') {
                    res = Math.max(res, bfs(chessboard, i, j));
                }
            }
        }
        return res;
    }

    private int bfs(String[] chessboard, int px, int py) {
        char[][] board = new char[chessboard.length][chessboard[0].length()];
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard[0].length(); j++) {
                board[i][j] = chessboard[i].charAt(j);
            }
        }
        int cnt = 0;
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[] {px, py});
        board[px][py] = 'X';
        while (!que.isEmpty()) {
            int[] t = que.poll();
            for (int[] dir : dirs) {
                if (judge(board, t[0], t[1], dir)) {
                    int x = t[0] + dir[0], y = t[1] + dir[1];
                    while (board[x][y] != 'X') {
                        que.offer(new int[] {x, y});
                        board[x][y] = 'X';
                        x += dir[0];
                        y += dir[1];
                        ++cnt;
                    }
                }
            }
        }
        return cnt;
    }

    private boolean judge(char[][] board, int i, int j, int[] dir) {
        i += dir[0];
        j += dir[1];
        while (0 <= i && i < board.length && 0 <= j && j < board[0].length) {
            if (board[i][j] == 'X') {
                return true;
            } else if (board[i][j] == '.') {
                return false;
            }
            i += dir[0];
            j += dir[1];
        }
        return false;
    }
}
// @lc code=end



/*
// @lcpr case=start
// ["....X.","....X.","XOOO..","......","......"]`>\n
// @lcpr case=end

// @lcpr case=start
// [".X.",".O.","XO."]`>\n
// @lcpr case=end

// @lcpr case=start
// [".......",".......",".......","X......",".O.....","..O....","....OOX"]`>\n
// @lcpr case=end

 */

