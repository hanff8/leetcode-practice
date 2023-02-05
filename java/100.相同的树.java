import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=100 lang=java
 * @lcpr version=21401
 *
 * [100] 相同的树
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
    public boolean dfs(TreeNode le, TreeNode rg) {
        if (le == null && rg == null)
            return true;
        if (le == null || rg == null)
            return false;
        if (le.val != rg.val)
            return false;
        return dfs(le.left, rg.left) && dfs(le.right, rg.right);

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        // return dfs(p, q);
        LinkedList<TreeNode> arrayDeque = new LinkedList<>();
        arrayDeque.add(p);
        arrayDeque.add(q);
        while (!arrayDeque.isEmpty()) {
            var pNode = arrayDeque.poll();
            var qNode = arrayDeque.poll();
            if (pNode == null && qNode == null)
                continue;
            if (pNode == null || qNode == null)
                return false;
            if (pNode.val != qNode.val)
                return false;
            arrayDeque.add(pNode.left);
            arrayDeque.add(qNode.left);
            arrayDeque.add(pNode.right);
            arrayDeque.add(qNode.right);
        }
        return true;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3]\n[1,2,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2]\n[1,null,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,1]\n[1,1,2]\n
 * // @lcpr case=end
 * 
 */
