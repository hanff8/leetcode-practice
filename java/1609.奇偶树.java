/*
 * @lc app=leetcode.cn id=1609 lang=java
 * 
 * @lcpr version=21907
 *
 * [1609] 奇偶树
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int level = 0;
        while (!deque.isEmpty()) {
            TreeNode node = null;
            int prev = -1, i = 0;
            int size = deque.size();
            while (i < size) {
                node = deque.poll();
                if (level % 2 == 0) {
                    if (node.val % 2 == 0)
                        return false;
                    if (prev != -1 && node.val <= prev)
                        return false;
                } else {
                    if (node.val % 2 == 1)
                        return false;
                    if (prev != -1 && node.val >= prev)
                        return false;
                }
                prev = node.val;
                if (node.left != null)
                    deque.add(node.left);
                if (node.right != null)
                    deque.add(node.right);
                ++i;
            }
            ++level;
        }
        return true;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // [1,10,4,3,null,7,9,12,8,6,null,null,2]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [5,4,2,3,3,7]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [5,9,1,3,5,7]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [11,8,6,1,3,9,11,30,20,18,16,12,10,4,2,17]\n // @lcpr case=end
 * 
 */

