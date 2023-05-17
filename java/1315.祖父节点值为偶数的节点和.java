/*
 * @lc app=leetcode.cn id=1315 lang=java
 * 
 * @lcpr version=21907
 *
 * [1315] 祖父节点值为偶数的节点和
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Deque;
import java.util.Map;
import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
// @lc code=start

import java.util.ArrayDeque;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
    int ans = 0;

    public void dfs(TreeNode node, TreeNode parentNode, TreeNode grandNode) {
        if (node == null)
            return;
        if (grandNode.val % 2 == 0)
            ans += node.val;
        dfs(node.left, node, parentNode);
        dfs(node.right, node, parentNode);
    }

    // dfs
    public int sumEvenGrandparent1(TreeNode root) {
        if (root.left != null) {
            dfs(root.left.left, root.left, root);
            dfs(root.left.right, root.left, root);
        }
        if (root.right != null) {
            dfs(root.right.right, root.right, root);
            dfs(root.right.left, root.right, root);
        }
        return ans;
    }

    // bfs
    public int sumEvenGrandparent(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            if (node.left != null) {
                if (node.left.left != null) {
                    if (node.val % 2 == 0) {
                        ans += node.left.left.val;
                    }
                }
                if (node.left.right != null) {
                    if (node.val % 2 == 0) {
                        ans += node.left.right.val;
                    }
                }
            }
            if (node.right != null) {
                if (node.right.right != null) {
                    if (node.val % 2 == 0) {
                        ans += node.right.right.val;
                    }
                }
                if (node.right.left != null) {
                    if (node.val % 2 == 0) {
                        ans += node.right.left.val;
                    }
                }
            }
            if (node.left != null)
                deque.add(node.left);
            if (node.right != null)
                deque.add(node.right);
        }
        return ans;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]\n // @lcpr case=end
 * 
 */

