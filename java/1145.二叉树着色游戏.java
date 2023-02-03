import java.util.ArrayDeque;
import java.util.Deque;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=1145 lang=java
 * @lcpr version=21401
 *
 * [1145] 二叉树着色游戏
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private int x, lez, rgz;

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int le = dfs(root.left);
        int rg = dfs(root.right);
        if (root.val == x) {
            lez = le;
            rgz = rg;
        }
        return le + rg + 1;
    }

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        this.x = x;
        dfs(root);
        return Math.max(Math.max(lez, rgz), n - 1 - lez - rgz) * 2 > n;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,4,5,6,7,8,9,10,11]\n11\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3]\n3\n1\n
 * // @lcpr case=end
 * 
 */
