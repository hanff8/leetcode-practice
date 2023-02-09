import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=103 lang=java
 * @lcpr version=21504
 *
 * [103] 二叉树的锯齿形层序遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<TreeNode> que = new ArrayDeque<>();
        if (root == null)
            return res;
        que.add(root);
        // res.add(Arrays.asList(root.val));
        int level = 2;
        while (!que.isEmpty()) {
            int currentSize = que.size();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode node = que.poll();
                if (node.left != null)
                    que.add(node.left);
                if (node.right != null)
                    que.add(node.right);
                list.add(node.val);
            }
            if (level % 2 != 0) {
                Collections.reverse(list);
            }
            if (list.size() > 0)
                res.add(list);
            ++level;
        }
        return res;
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
 * // [1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n
 * // @lcpr case=end
 * 
 */
