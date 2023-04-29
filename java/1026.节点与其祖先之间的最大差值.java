/*
 * @lc app=leetcode.cn id=1026 lang=java
 * 
 * @lcpr version=21906
 *
 * [1026] 节点与其祖先之间的最大差值
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {

    public int dfs(TreeNode root, int mi, int ma) {
        if (root == null)
            return 0;
        int diff = Math.max(Math.abs(root.val - mi), Math.abs(root.val - ma));
        mi = Math.min(mi, root.val);
        ma = Math.max(ma, root.val);
        diff = Math.max(diff, dfs(root.left, mi, ma));
        diff = Math.max(diff, dfs(root.right, mi, ma));
        return diff;
    }

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }
}
// @lc code=end



/*
 * // @lcpr case=start // [8,3,10,1,6,null,14,null,null,4,7,13]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1,null,2,null,0,3]\n // @lcpr case=end
 * 
 */

