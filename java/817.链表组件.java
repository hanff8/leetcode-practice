/*
 * @lc app=leetcode.cn id=817 lang=java
 * 
 * @lcpr version=21907
 *
 * [817] 链表组件
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int val : nums) {
            set.add(val);
        }
        int i = 0, ans = 0;
        boolean inSet = false;
        while (head != null) {
            if (set.contains(head.val)) {
                if (!inSet) {
                    inSet = true;
                    ans++;
                }
            } else {
                inSet = false;
            }
            head = head.next;
        }
        return ans;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // [0,1,2,3]\n[0,1,3]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [0,1,2,3,4]\n[0,3,1,4]\n // @lcpr case=end
 * 
 */

