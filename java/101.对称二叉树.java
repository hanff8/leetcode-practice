import java.util.ArrayDeque;
import java.util.Deque;
/*
 * @lc app=leetcode.cn id=101 lang=java
 * @lcpr version=21401
 *
 * [101] 对称二叉树
 */
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

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
    public boolean dfs(TreeNode le, TreeNode rg) {
        if (le == null && rg == null)
            return true;
        if (le == null || rg == null)
            return false;
        if (le.val != rg.val)
            return false;
        return dfs(le.left, rg.right) && dfs(le.right, rg.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        return dfs(root.left, root.right);
        // if (root == null || (root.left == null && root.right == null))
        // return true;
        // LinkedList<TreeNode> linkedList = new LinkedList<>();
        // linkedList.add(root.left);
        // linkedList.add(root.right);
        // while (!linkedList.isEmpty()) {
        // var le = linkedList.poll();
        // var rg = linkedList.poll();
        // if (le == null && rg == null)
        // continue;
        // if (le == null || rg == null)
        // return false;
        // if (le.val != rg.val)
        // return false;
        // linkedList.add(le.left);
        // linkedList.add(rg.right);
        // linkedList.add(le.right);
        // linkedList.add(rg.left);
        // }
        // return true;

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,2,3,4,4,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,2,null,3,null,3]\n
 * // @lcpr case=end
 * 
 */
