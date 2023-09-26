/*
 * @lc app=leetcode.cn id=337 lang=java
 * 
 * @lcpr version=21913
 *
 * [337] 打家劫舍 III
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
	// 选择当前节点
	Map<TreeNode, Integer> f = new HashMap<>();
	// 不选择当前节点
	Map<TreeNode, Integer> g = new HashMap<>();

	public int rob(TreeNode root) {
		dfs(root);
		return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
	}

	public void dfs(TreeNode root) {
		if (root == null)
			return;
		dfs(root.left);
		dfs(root.right);
		System.out.println(root.val);
		f.put(root, root.val + g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0));
		g.put(root, Math.max(f.getOrDefault(root.left, 0), g.getOrDefault(root.left, 0))
				+ Math.max(g.getOrDefault(root.right, 0), f.getOrDefault(root.right, 0)));
	}
}
// @lc code=end



/*
// @lcpr case=start
// [3,2,3,null,3,null,1]\n
// @lcpr case=end

// @lcpr case=start
// [3,4,5,1,3,null,1]\n
// @lcpr case=end

 */

