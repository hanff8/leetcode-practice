import java.util.ArrayDeque;
import java.util.Deque;
import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=226 lang=java
 * 
 * @lcpr version=21801
 *
 * [226] 翻转二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
    // public TreeNode invertTree(TreeNode root) {
    // if (root == null)
    // return root;
    // Deque<TreeNode> deque = new ArrayDeque<>();
    // deque.push(root);
    // while (!deque.isEmpty()) {
    // int size = deque.size();
    // TreeNode node = deque.poll();
    // TreeNode tmp = node.left;
    // node.left = node.right;
    // node.right = tmp;

    // if (node.left != null)
    // deque.add(node.left);
    // if (node.right != null)
    // deque.add(node.right);
    // }
    // return root;
    // }
    public TreeNode dfs(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);
        TreeNode tmp = left;
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // [4,2,7,1,3,6,9]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [2,1,3]\n // @lcpr case=end
 * 
 * // @lcpr case=start // []\n // @lcpr case=end
 * 
 */


