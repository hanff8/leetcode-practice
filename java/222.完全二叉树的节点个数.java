/*
 * @lc app=leetcode.cn id=222 lang=java
 * 
 * @lcpr version=21906
 *
 * [222] 完全二叉树的节点个数
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        // 完全二叉树性质
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (exist(root, level, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low - 1;
    }

    public boolean exist(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // [1,2,3,4,5,6]\n // @lcpr case=end
 * 
 * // @lcpr case=start // []\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1]\n // @lcpr case=end
 * 
 */

