import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=617 lang=java
 * 
 * @lcpr version=21801
 *
 * [617] 合并二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
    public TreeNode dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        // TreeNode merge = new TreeNode(root1.val + root2.val);
        root1.val += root2.val;
        TreeNode left = dfs(root1.left, root2.left);
        TreeNode right = dfs(root1.right, root2.right);
        root1.left = left;
        root1.right = right;
        return root1;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return root1 == null ? root2 : root1;
        dfs(root1, root2);
        return root1;
    }

    // public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    // if (root1 == null || root2 == null)
    // return root1 == null ? root2 : root1;
    // Deque<TreeNode> deque = new LinkedList<>();
    // deque.add(root1);
    // deque.add(root2);
    // while (!deque.isEmpty()) {
    // TreeNode node1 = deque.poll();
    // TreeNode node2 = deque.poll();
    // node1.val += node2.val;
    // if (node1.left != null && node2.left != null) {
    // deque.add(node1.left);
    // deque.add(node2.left);
    // } else if (node1.left == null) {
    // node1.left = node2.left;
    // }
    // if (node1.right != null && node2.right != null) {
    // deque.add(node1.right);
    // deque.add(node2.right);
    // } else if (node1.right == null) {
    // node1.right = node2.right;
    // }
    // }
    // return root1;
    // }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // [1,3,2,5]\n[2,1,3,null,4,null,7]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1]\n[1,2]\n // @lcpr case=end
 * 
 */


