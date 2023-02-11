import java.util.ArrayDeque;
import java.util.Deque;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=112 lang=java
 * @lcpr version=21504
 *
 * [112] 路径总和
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

    // public boolean hasPathSum(TreeNode root, int targetSum) {
    // if (root == null)
    // return false;
    // targetSum = targetSum - root.val;
    // if (root.left == null && root.right == null)
    // if (targetSum == 0)
    // return true;
    // else
    // return false;
    // return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);

    // }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        Deque<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        targetSum = targetSum - root.val;
        while (!que.isEmpty()) {
            if (root.left != null)
                que.add(root.left);
            if (root.right != null)
                que.add(root.right);

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
 * // [5,4,8,11,null,13,4,7,2,null,null,null,1]\n22\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3]\n5\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n0\n
 * // @lcpr case=end
 * 
 */
