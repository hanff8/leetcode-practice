/*
 * @lc app=leetcode.cn id=1171 lang=java
 * 
 * @lcpr version=21909
 *
 * [1171] 从链表中删去总和值为零的连续节点
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution {

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int prefix = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            prefix += node.val;
            map.put(prefix, node);
        }
        prefix = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            prefix += node.val;
            node.next = map.get(prefix).next;
        }
        return dummy.next;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,-3,3,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,-3,4]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,-3,-2]\n
// @lcpr case=end

 */

