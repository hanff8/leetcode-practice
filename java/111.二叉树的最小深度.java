import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=111 lang=java
 * @lcpr version=21504
 *
 * [111] 二叉树的最小深度
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
    public int dfs(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int m1 = dfs(root.left);
        int m2 = dfs(root.right);
        if (root.left == null || root.right == null)
            return m1 + m2 + 1;
        return Math.min(m1, m2) + 1;
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Deque<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        int level = 1;
        while (!que.isEmpty()) {
            int currentLevel = que.size();

            for (int i = 0; i < currentLevel; i++) {
                var node = que.poll();
                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null)
                    que.add(node.left);
                if (node.right != null)
                    que.add(node.right);

            }
            level++;
        }
        return 0;
        // return dfs(root);
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end

/*
 * // @lcpr case=start
 * // [3,9,20,null,null,15,7]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,null,3,null,4,null,5,null,6]\n
 * // @lcpr case=end
 * 
 */
