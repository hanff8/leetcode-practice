import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=1038 lang=java
 * 
 * @lcpr version=21801
 *
 * [1038] 从二叉搜索树到更大和树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            bstToGst(root.right);
            sum += root.val;
            root.val = sum;
            bstToGst(root.left);
        }
        return root;
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // // @lcpr case=end
 * 
 * // @lcpr case=start // [0,null,1]\n // @lcpr case=end
 * 
 */


