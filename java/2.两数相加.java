/*
 * @lc app=leetcode.cn id=2 lang=java
 * @lcpr version=21105
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 进位
        int plus = 0;
        ListNode head = l1;
        while (l1 != null || l2 != null) {
            if (l2 != null && l2 != null)
                l1.val += l2.val + plus;
            else if (l2 == null)
                l1.val += plus;

            if (l1.val / 10 != 0) {
                plus = l1.val / 10;
                l1.val %= 10;
            } else {
                plus = 0;
            }
            if (l1.next == null && l2 != null && l2.next != null) {
                l1.next = l2.next;
                l2.next = null;
            }
            if (plus != 0 && l1.next == null) {
                l1.next = new ListNode(plus);
                break;
            }

            l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return head;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2,4,3]\n[5,6,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0]\n[0]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [9,9,9,9,9,9,9]\n[9,9,9,9]\n
 * // @lcpr case=end
 * 
 */
