/*
 * @lc app=leetcode.cn id=783 lang=java
 * @lcpr version=21801
 *
 * [783] 二叉搜索树节点最小距离
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int ans, pre;

    public void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, Math.abs(root.val - pre));
            pre = root.val;
        }
        dfs(root.right);
    }

    public int minDiffInBST(TreeNode root) {
        // int ans = 0;
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end

/*
 * // @lcpr case=start
 * // [4,2,6,1,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,0,48,null,null,12,49]\n
 * // @lcpr case=end
 * 
 */
