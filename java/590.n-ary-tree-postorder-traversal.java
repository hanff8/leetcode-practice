/*
 * @lc app=leetcode.cn id=590 lang=java
 * 
 * @lcpr version=21913
 *
 * [590] N 叉树的后序遍历
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Deque;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayDeque;
// @lc code=start
/*
 * // Definition for a Node. class Node { public int val; public List<Node> children;
 * 
 * public Node() {}
 * 
 * public Node(int _val) { val = _val; }
 * 
 * public Node(int _val, List<Node> _children) { val = _val; children = _children; } };
 */

class Solution {
	public List<Integer> postorder(Node root) {
		List<Integer> res = new ArrayList<>();
		// dfs(root, res);
		return iterate_func(root);
	}

	private List<Integer> iterate_func(Node root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		Map<Node, Integer> map = new HashMap<>();
		Deque<Node> stack = new ArrayDeque<>();
		Node node = root;
		while (!stack.isEmpty() || node != null) {
			while (node != null) {
				stack.push(node);
				List<Node> children = node.children;
				if (children != null && children.size() > 0) {
					map.put(node, 0);
					node = children.get(0);
				} else {
					node = null;
				}
			}
			node = stack.peek();
			int index = map.getOrDefault(node, -1) + 1;
			List<Node> children = node.children;
			if (children != null && children.size() > index) {
				map.put(node, index);
				node = children.get(index);
			} else {
				res.add(node.val);
				stack.pop();
				map.remove(node);
				node = null;
			}
		}
		return res;
	}

	private void dfs(Node root, List<Integer> res) {
		if (root == null) {
			return;
		}
		for (Node no : root.children) {
			dfs(no, res);
		}
		res.add(root.val);
	}
}
// @lc code=end



/*
// @lcpr case=start
// [1,null,3,2,4,null,5,6]\n
// @lcpr case=end

// @lcpr case=start
// [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]\n
// @lcpr case=end

 */

