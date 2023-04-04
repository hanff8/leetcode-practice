import java.net.CacheResponse;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.security.auth.login.CredentialException;

/*
 * @lc app=leetcode.cn id=146 lang=java
 * @lcpr version=21901
 *
 * [146] LRU 缓存
 */

// @lc code=start
// class LRUCache extends LinkedHashMap<Integer, Integer> {
//     int capacity;
//     int currentNum;

//     public LRUCache(int capacity) {
//         super(capacity, 0.75F, true);
//         this.capacity = capacity;
//     }

//     public int get(int key) {
//         return super.getOrDefault(key, -1);
//     }

//     public void put(int key, int value) {
//         super.put(key, value);
//     }

//     @Override
//     protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//         return size() > capacity;
//     }
// }
class LRUCache {
    class ListNode {
        int key;
        int val;
        ListNode pre;
        ListNode next;

        ListNode() {
        }

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    int currentNum;
    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;

    public LRUCache(int capsacity) {
        this.capacity = capsacity;
        map = new HashMap<>();
        head = new ListNode();
        tail = new ListNode();
        this.currentNum = 0;
        head.next = tail;
        tail.pre = head;
    }

    public void addToHead(ListNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    public void removeNode(ListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void moveToHead(ListNode node) {
        removeNode(node);
        addToHead(node);
    }

    public ListNode removeTail() {
        ListNode res = tail.pre;
        removeNode(res);
        return res;
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        ListNode node = map.get(key);
        if (node == null) {
            node = new ListNode(key, value);
            ++currentNum;
            map.put(key, node);
            addToHead(node);
            if (currentNum > capacity) {
                // 删除节点
                ListNode tail = removeTail();
                map.remove(tail.key);
                --currentNum;
            }
        } else {
            node.val = value;
            moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
