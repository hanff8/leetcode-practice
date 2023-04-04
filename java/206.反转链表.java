import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=206 lang=java
 * @lcpr version=21901
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList1(ListNode head) {
        if (head == null)
            return null;
        Deque<ListNode> que = new ArrayDeque<>();
        while (head != null) {
            que.push(head);
            head = head.next;
        }
        ListNode dummy = new ListNode();
        dummy.next = que.pop();
        ListNode newHead = dummy.next;
        newHead.next = null;
        while (!que.isEmpty()) {
            ListNode node = que.pop();
            newHead.next = node;
            node.next = null;
            newHead = newHead.next;
            // System.out.println(node.val);
        }
        return dummy.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode fast = head, slow = null;
        while (fast != null) {
            ListNode next = fast.next;
            fast.next = slow;
            // slow.next = null;
            slow = fast;
            fast = next;
        }
        return slow;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,4,5]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n
 * // @lcpr case=end
 * 
 */
