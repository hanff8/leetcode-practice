import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1721 lang=java
 * 
 * @lcpr version=21801
 *
 * [1721] 交换链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        // 双指针交换节点值
        // int i = 1;
        // ListNode cur = head, first = head, last = head;
        // while (cur.next != null) {
        // if (i < k)
        // first = first.next;
        // else
        // last = last.next;
        // i++;
        // cur = cur.next;
        // }
        // i = first.val;
        // first.val = last.val;
        // last.val = i;
        // return head;
        // 创建list数组,利用数组索引交换节点值
        // if (head.next == null)
        // return head;
        // List<ListNode> list = new ArrayList<>();
        // ListNode cur = head;
        // while (cur != null) {
        // list.add(cur);
        // cur = cur.next;
        // }

        // ListNode node1 = list.get(k - 1);
        // ListNode node2 = list.get(list.size() - k);

        // int tmp = node1.val;
        // node1.val = node2.val;
        // node2.val = tmp;
        // return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;// 因为头结点可能会发生交换，所以要构造一个哑结点
        ListNode pre1 = dummy;// pre1指向第k个节点的前一个节点
        ListNode left = dummy.next;// 第k个节点
        ListNode pre2 = dummy;// pre2指向倒数第k个节点的前一个节点
        ListNode right = dummy.next;// 倒数第k个节点
        for (int i = 1; i < k; i++) {
            pre1 = pre1.next;
            left = left.next;
        }
        ListNode cur = left;
        ListNode temp = left.next;// 第k个节点的后一个节点
        while (cur.next != null) {
            pre2 = pre2.next;
            right = right.next;
            cur = cur.next;
        }
        if (right == pre1) {// 特殊情况，倒数第k个节点在第k个节点的左侧
            right.next = temp;
            left.next = right;
            pre2.next = left;
        } else {
            left.next = right.next;
            if (pre2 == left) {
                right.next = left;
            } // 特殊情况，第k个节点在倒数第k个节点的左侧
            else {
                pre2.next = left;
                right.next = temp;
            }
            pre1.next = right;
        }
        return dummy.next;
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // [1,2,3,4,5]\n2\n // @lcpr case=end
 * 
 * // @lcpr case=start // [7,9,6,6,7,8,3,0,9,5]\n5\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1]\n1\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1,2]\n1\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1,2,3]\n2\n // @lcpr case=end
 * 
 */


