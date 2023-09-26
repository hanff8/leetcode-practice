/*
 * @lc app=leetcode.cn id=1993 lang=java
 * 
 * @lcpr version=21917
 *
 * [1993] 树上的操作
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Deque;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayDeque;
// @lc code=start


class LockingTree {
	List<Integer>[] childrens;
	int[] parent;
	int[] lockNodeUser; //lockNodeUser[i]==0 说明没有上锁


	public LockingTree(int[] parent) {
		this.parent = parent;
		this.lockNodeUser = new int[parent.length];
		this.childrens = new List[parent.length];
		Arrays.setAll(this.childrens, a -> new ArrayList<>());
		Arrays.fill(lockNodeUser, -1);
		for (int i = 0; i < parent.length; i++) {
			if (parent[i] != -1)
				childrens[parent[i]].add(i);
		}
	}

	public boolean lock(int num, int user) {
		if (lockNodeUser[num] == -1) {
			lockNodeUser[num] = user;
			return true;
		}
		return false;
	}

	public boolean unlock(int num, int user) {
		if (lockNodeUser[num] == user) {
			lockNodeUser[num] = -1;
			return true;
		}
		return false;
	}

	public boolean upgrade(int num, int user) {
		if (lockNodeUser[num] == -1 && !checkParent(num) && checkAndUnlockDescendant(num)) {
			lockNodeUser[num] = user;
			return true;
		}
		return false;
	}

	private boolean checkParent(int num) {
		while (parent[num] != -1) {
			if (lockNodeUser[parent[num]] != -1) {
				return true;
			}
			num = parent[num];
		}
		return false;
	}

	private boolean checkAndUnlockDescendant(int num) {
		boolean res = lockNodeUser[num] != -1;
		lockNodeUser[num] = -1;
		for (int child : childrens[num]) {
			res |= checkAndUnlockDescendant(child);
		}
		return res;
	}
}

/**
 * Your LockingTree object will be instantiated and called as such: LockingTree obj = new
 * LockingTree(parent); boolean param_1 = obj.lock(num,user); boolean param_2 =
 * obj.unlock(num,user); boolean param_3 = obj.upgrade(num,user);
 */
// @lc code=end



/*
// @lcpr case=start
// ["LockingTree", "lock", "unlock", "unlock", "lock", "upgrade", "lock"][[[-1, 0, 0, 1, 1, 2, 2]], [2, 2], [2, 3], [2, 2], [4, 5], [0, 1], [0, 1]]\n
// @lcpr case=end

 */

