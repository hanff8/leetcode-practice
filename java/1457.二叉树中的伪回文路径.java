/*
 * @lc app=leetcode.cn id=1457 lang=java
 * 
 * @lcpr version=21907
 *
 * [1457] 二叉树中的伪回文路径
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
    int ans = 0;

    public void dfs(TreeNode node, int prev) {
        int n = prev ^ (1 << node.val);
        if (node.left == null && node.right == null) {
            if (n == 0 || (n & (n - 1)) == 0) {
                ++ans;
                return;
            }
        }
        if (node.left != null)
            dfs(node.left, n);
        if (node.right != null)
            dfs(node.right, n);
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // [2,3,1,3,1,null,1]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [2,1,1,1,3,null,null,null,null,null,1]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [9]\n // @lcpr case=end
 * 
 */

