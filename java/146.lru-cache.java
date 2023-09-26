/*
 * @lc app=leetcode.cn id=146 lang=java
 * 
 * @lcpr version=21917
 *
 * [146] LRU 缓存
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayDeque;
import java.util.Deque;

// @lc code=start
class LRUCache {


	class Node {
		int key;
		int value;
		Node next;
		Node prev;

		public Node() {}

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	int capacity;
	Map<Integer, Node> map;
	Node head;
	Node tail;
	Node cur;
	int cnt = 0;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<>();
		head = new Node();
		cur = head;

		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		Node node = map.get(key);

		if (node == null)
			return -1;

		moveToHead(node);
		return node.value;

	}

	private void moveToHead(LRUCache.Node node) {
		// 与当前位置的前驱与后置节点脱离
		delNode(node);

		// 将当前节点加入头节点之后
		addToHead(node);
	}

	public void put(int key, int value) {
		// Node tmp = new Node(key, value);
		// map.put(key, tmp);
		Node node = map.get(key);
		if (node == null) {
			node = new Node(key, value);
			map.put(key, node);
			++cnt;
			addToHead(node);
			if (cnt > capacity) {
				cnt--;
				// 删除map中的键值对
				// 删除双向链表最后一个节点
				Node tailNode = removeTail();
				map.remove(tailNode.key);
			}
		} else {
			node.value = value;
			moveToHead(node);
		}
	}

	private Node removeTail() {
		Node nd = tail.prev;
		delNode(nd);
		return nd;
	}

	private void delNode(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	private void addToHead(Node node) {
		// 新加入的节点放进链表最前面
		node.prev = head;
		node.next = head.next;
		head.next.prev = node;
		head.next = node;
	}
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj = new
 * LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end


