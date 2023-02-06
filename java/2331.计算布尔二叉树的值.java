import java.util.HashMap;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=2331 lang=java
 * @lcpr version=21504
 *
 * [2331] 计算布尔二叉树的值
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

    // public boolean dfs(TreeNode root) {
    // if (root.left == null && root.right == null) {
    // if (root.val == 1)
    // return true;
    // if (root.val == 0)
    // return false;
    // }
    // if (root.val == 2)
    // return dfs(root.left) | dfs(root.right);
    // else
    // return dfs(root.left) & dfs(root.right);

    // }

    // public boolean evaluateTree(TreeNode root) {
    // if (root == null) {
    // return false;
    // }
    // return dfs(root);
    // }
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null)
            return root.val == 1;
        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
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
 * // [2,1,3,null,null,0,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0]\n
 * // @lcpr case=end
 * 
 */
