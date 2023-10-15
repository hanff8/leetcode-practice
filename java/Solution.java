class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
//		solution.expandBinaryTree();
	}

	public TreeNode dfs(TreeNode root, TreeNode parent, int direct) {
		if (root == null)
			return null;
		if (root.left == null || root.right == null)
			return root;
		TreeNode left = dfs(root.left, root, -1);
		TreeNode right = dfs(root.right, root, 1);
		if (parent != null && left != null || right != null) {
			TreeNode node = new TreeNode(-1);
			if (node.left != null)
				node.left = left;
			if (node.right != null)
				node.right = right;
			if (direct == -1)
				root.left = node;
			if (direct == 1)
				root.right = node;
			return node;
		}
		return root;
	}

	public TreeNode expandBinaryTree(TreeNode root) {
		return dfs(root, root, -1);
	}
}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
