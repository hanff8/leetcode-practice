/*
 * @lc app=leetcode.cn id=1669 lang=java
 * @lcpr version=21302
 *
 * [1669] 合并两个链表
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prev1 = null, prev2 = null, head = list1, tail2 = list2, removeList = null;
        int i = 0, j = 0;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }
        // 获取a-1节点

        while (list1 != null) {
            if (i == a) {
                // a
                removeList = list1;
                // 连接
                prev1.next = list2;
                break;
            }
            prev1 = list1;
            list1 = list1.next;
            ++i;
        }
        // 获取b节点
        j = i;
        while (removeList != null) {
            prev2 = removeList;
            removeList = removeList.next;
            if (j == b) {
                // b
                prev2.next = null;

                tail2.next = removeList;
                break;
            }
            ++j;
        }

        return head;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [0,1,2,3,4,5]\n3\n4\n[1000000,1000001,1000002]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0,1,2,3,4,5,6]\n2\n5\n[1000000,1000001,1000002,1000003,1000004]\n
 * // @lcpr case=end
 * 
 */
