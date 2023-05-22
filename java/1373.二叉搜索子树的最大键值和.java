/*
 * @lc app=leetcode.cn id=1373 lang=java
 * 
 * @lcpr version=21908
 *
 * [1373] 二叉搜索子树的最大键值和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
    static int INF = Integer.MAX_VALUE;
    int res = 0;

    class SubTree {
        boolean isBST;
        int minValue;
        int maxValue;
        int sumValue;

        public SubTree(boolean isBST, int minValue, int maxValue, int sumValue) {
            this.isBST = isBST;
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.sumValue = sumValue;
        }
    }

    public int maxSumBST(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    public SubTree dfs(TreeNode node) {
        if (node == null)
            return new SubTree(true, INF, -INF, 0);
        SubTree left = dfs(node.left);
        SubTree right = dfs(node.right);
        if (left.isBST && right.isBST && node.val > left.maxValue && node.val < right.minValue) {
            int sum = node.val + left.sumValue + right.sumValue;
            res = Math.max(res, sum);
            return new SubTree(true, Math.min(left.minValue, node.val),
                    Math.max(right.maxValue, node.val), sum);
        } else {
            return new SubTree(false, 0, 0, 0);
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]\n
// @lcpr case=end

// @lcpr case=start
// [4,3,null,1,2]\n
// @lcpr case=end

// @lcpr case=start
// [-4,-2,-5]\n
// @lcpr case=end

// @lcpr case=start
// [2,1,3]\n
// @lcpr case=end

// @lcpr case=start
// [5,4,8,3,null,6,3]\n
// @lcpr case=end

 */

