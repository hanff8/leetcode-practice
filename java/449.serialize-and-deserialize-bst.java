/*
 * @lc app=leetcode.cn id=449 lang=java
 * 
 * @lcpr version=21913
 *
 * [449] 序列化和反序列化二叉搜索树
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Deque;
import java.util.Map;
import java.util.Queue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
// @lc code=start

import java.util.ArrayList;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
public class Codec {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		postOrder(root, list);
		String str = list.toString();
		return str.substring(1, str.length() - 1);
	}

	private void postOrder(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		postOrder(root.left, list);
		postOrder(root.right, list);
		list.add(root.val);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.isEmpty()) {
			return null;
		}
		String[] arr = data.split(", ");
		Deque<Integer> stack = new ArrayDeque<>();
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			stack.push(Integer.parseInt(arr[i]));
		}
		return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
	}

	private TreeNode construct(int minValue, int maxValue, Deque<Integer> stack) {
		if (stack.isEmpty() || stack.peek() < minValue || stack.peek() > maxValue) {
			return null;
		}
		int val = stack.pop();
		TreeNode root = new TreeNode(val);
		root.right = construct(val, maxValue, stack);
		root.left = construct(minValue, val, stack);
		return root;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
// @lc code=end



/*
// @lcpr case=start
// [2,1,3]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

 */

