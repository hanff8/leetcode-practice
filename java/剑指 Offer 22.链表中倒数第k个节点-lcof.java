/*
 * @lc app=leetcode.cn id=剑指 Offer 22 lang=java
 * 
 * @lcpr version=21913
 *
 * [剑指 Offer 22] 链表中倒数第k个节点
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
	public ListNode getKthFromEnd(ListNode head, int k) {
		ListNode slow = head, fast = head;
		while (k != 0) {
			fast = fast.next;
			k--;
		}
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}
// @lc code=end
