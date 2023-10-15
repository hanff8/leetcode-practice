/*
 * @lc app=leetcode.cn id=LCP 67 lang=java
 * 
 * @lcpr version=21917
 *
 * [LCP 67] 装饰树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
	public TreeNode dfs(TreeNode root) {
		if (root == null || root.left == null && root.right == null)
			return root;
		if (root.left != null)
			root.left = new TreeNode(-1, dfs(root.left), null);
		if (root.right != null)
			root.right = new TreeNode(-1, null, root.right);
		return root;
	}

	public TreeNode expandBinaryTree(TreeNode root) {
		return dfs(root);
	}
}
// @lc code=end



/*
// @lcpr case=start
// [7,5,6]`>\n
// @lcpr case=end

// @lcpr case=start
// [3,1,7,3,8,null,4]`>\n
// @lcpr case=end

 */

