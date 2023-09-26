/*
 * @lc app=leetcode.cn id=1123 lang=java
 * 
 * @lcpr version=21913
 *
 * [1123] 最深叶节点的最近公共祖先
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayDeque;

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
	int breaktag = 0;

	public Node dfs(TreeNode root) {
		if (root == null) {
			return new Node(root, 0);
		}
		var left = dfs(root.left);
		var right = dfs(root.right);
		if (left.degree > right.degree) {
			return new Node(left.node, left.degree + 1);
		}
		if (left.degree < right.degree) {
			return new Node(right.node, right.degree + 1);
		}
		return new Node(root, left.degree + 1);
	}

	public TreeNode lcaDeepestLeaves(TreeNode root) {
		return dfs(root).node;
	}

	class Node {
		TreeNode node;
		int degree;

		Node(TreeNode node, int degree) {
			this.node = node;
			this.degree = degree;
		}

	}
}
// @lc code=end



/*
// @lcpr case=start
// [3,5,1,6,2,0,8,null,null,7,4]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

// @lcpr case=start
// [0,1,3,null,2]\n
// @lcpr case=end

 */

