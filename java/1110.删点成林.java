/*
 * @lc app=leetcode.cn id=1110 lang=java
 * 
 * @lcpr version=21908
 *
 * [1110] 删点成林
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {

    public TreeNode dfs(List<TreeNode> ans, TreeNode root, Set<Integer> set) {
        if (root == null)
            return null;
        root.left = dfs(ans, root.left, set);
        root.right = dfs(ans, root.right, set);
        if (!set.contains(root.val))
            return root;
        if (root.left != null)
            ans.add(root.left);
        if (root.right != null)
            ans.add(root.right);
        return null;
        //main


    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        List<TreeNode> ans = new ArrayList<>();
        for (var i : to_delete)
            set.add(i);
        if (dfs(ans, root, set) != null)
            ans.add(root);
        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5,6,7]\n[3,5]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,4,null,3]\n[3]\n
// @lcpr case=end

 */

