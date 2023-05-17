/*
 * @lc app=leetcode.cn id=654 lang=java
 * 
 * @lcpr version=21907
 *
 * [654] 最大二叉树
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
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
    public TreeNode dfs(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }
        int best = i;
        // 找最大值
        for (int k = i + 1; k <= j; k++) {
            if (nums[k] > nums[best])
                best = k;
        }
        TreeNode node = new TreeNode(nums[best]);
        node.left = dfs(nums, i, best - 1);
        node.right = dfs(nums, best + 1, j);
        return node;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }
}
// @lc code=end



/*
 * // @lcpr case=start // [3,2,1,6,0,5]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [3,2,1]\n // @lcpr case=end
 * 
 */

