/*
 * @lc app=leetcode.cn id=1080 lang=java
 * 
 * @lcpr version=21908
 *
 * [1080] 根到叶路径上的不足节点
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
    public boolean dfs(TreeNode root, int limit, int sum) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return sum + root.val < limit;

        boolean isLeft = dfs(root.left, limit, sum + root.val);
        boolean isRight = dfs(root.right, limit, sum + root.val);
        if (isLeft) {
            root.left = null;
        }
        if (isRight) {
            root.right = null;
        }
        // 左右子树都符合条件的话则返回true
        return isLeft && isRight;
    }

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean flag = dfs(root, limit, 0);
        return flag ? null : root;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14]\n1\n
// @lcpr case=end

// @lcpr case=start
// [5,4,8,11,null,17,4,7,1,null,null,5,3]\n22\n
// @lcpr case=end

// @lcpr case=start
// [1,2,-3,-5,null,4,null]\n-1\n
// @lcpr case=end

 */

