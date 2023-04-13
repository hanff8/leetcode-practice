import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1019 lang=java
 * 
 * @lcpr version=21902
 *
 * [1019] 链表中的下一个更大节点
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ListNode nxt = head.next;
            int target = head.val;
            while (nxt != null && nxt.val <= target) {
                nxt = nxt.next;
            }
            if (nxt != null)
                ans.add(nxt.val);
            else {
                ans.add(0);
            }
            head = head.next;
        }
        return ans.stream().mapToInt(x -> x).toArray();
    }
}
// @lc code=end



/*
 * // @lcpr case=start // [2,1,5]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [2,7,4,3,5]\n // @lcpr case=end
 * 
 */


