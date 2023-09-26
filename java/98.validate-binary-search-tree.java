/*
 * @lc app=leetcode.cn id=98 lang=java
 * 
 * @lcpr version=21917
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
	long pre = Long.MIN_VALUE;

	public boolean isValidBST(TreeNode root) {
		// return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
		// return dfs(root);
		return dfs(root)[1] != Long.MAX_VALUE;
	}

	// 前序遍历
	private boolean dfs(TreeNode root, long low, long high) {
		if (root == null)
			return true;

		if (root.val <= low || root.val >= high)
			return false;
		return dfs(root.left, low, root.val) && dfs(root.right, root.val, high);
	}

	// // 中序遍历
	// private boolean dfs(TreeNode root) {
	// 	if (root == null)
	// 		return true;
	// 	if (!dfs(root.left) || root.val < pre) {
	// 		return false;
	// 	}
	// 	pre = root.val;
	// 	return dfs(root.right);
	// }

	// 后序遍历
	private long[] dfs(TreeNode root) {
		if (root == null)
			return new long[] {Long.MAX_VALUE, Long.MIN_VALUE};
		long[] left = dfs(root.left);
		long[] right = dfs(root.right);
		long x = root.val;
		if (left[1] >= x || right[0] <= x) {
			return new long[] {Long.MIN_VALUE, Long.MAX_VALUE};
		}
		return new long[] {Math.min(left[0], x), Math.max(x, right[1])};
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

