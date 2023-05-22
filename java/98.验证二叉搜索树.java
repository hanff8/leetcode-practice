/*
 * @lc app=leetcode.cn id=98 lang=java
 * 
 * @lcpr version=21908
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
    public boolean isValidBST(TreeNode node, long left, long right) {
        if (node == null)
            return true;
        long x = node.val;
        return left < x && x < right && isValidBST(node.left, left, x)
                && isValidBST(node.right, x, right);
    }

    private long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (!isValidBST(root.left) || root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
        // return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,1,3]\n
// @lcpr case=end

// @lcpr case=start
// [5,1,4,null,null,3,6]\n
// @lcpr case=end

 */

