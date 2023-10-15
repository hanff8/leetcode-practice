/*
 * @lc app=leetcode.cn id=2251 lang=java
 * 
 * @lcpr version=21917
 *
 * [2251] 花期内花的数目
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.IntStream;
import java.util.ArrayDeque;
import java.util.Deque;

// @lc code=start
class Solution {

	public int[] fullBloomFlowers(int[][] flowers, int[] people) {
		// return solution1(flowers, people);
		return solution2(flowers, people);
	}

	private int[] solution2(int[][] flowers, int[] people) {
		var diff = new TreeMap<Integer, Integer>();
		for (int[] f : flowers) {
			diff.merge(f[0], 1, Integer::sum);
			diff.merge(f[1] + 1, -1, Integer::sum);
		}
		System.out.println(diff);
		int n = people.length;
		var id = new Integer[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}

		Arrays.sort(id, (i, j) -> people[i] - people[j]);

		var it = new PeekingIterator<>(diff.entrySet().iterator());
		int sum = 0;
		for (int i : id) {
			while (it.hasNext() && it.peek().getKey() <= people[i]) {
				sum += it.next().getValue();
			}
			people[i] = sum;
		}
		return people;
	}

	private int[] solution1(int[][] flowers, int[] people) {
		int n = flowers.length;
		int[] start = new int[n];
		int[] end = new int[n];
		for (int i = 0; i < n; i++) {
			start[i] = flowers[i][0];
			end[i] = flowers[i][1];
		}
		Arrays.sort(start);
		Arrays.sort(end);

		System.out.println(Arrays.toString(start));
		System.out.println(Arrays.toString(end));

		for (int i = 0; i < people.length; i++) {
			people[i] = binaryS(start, people[i] + 1) - binaryS(end, people[i]);
		}



		return people;
	}

	private static class PeekingIterator<E> implements Iterator<E> {
		private final Iterator<E> iterator;
		private E nextElement;

		public PeekingIterator(Iterator<E> iterator) {
			this.iterator = iterator;
			if (iterator.hasNext()) {
				nextElement = iterator.next();
			}
		}

		public E peek() {
			return nextElement;
		}

		@Override
		public E next() {
			E currentElement = nextElement;
			nextElement = iterator.hasNext() ? iterator.next() : null;
			return currentElement;
		}

		@Override
		public boolean hasNext() {
			return nextElement != null;
		}

	}

	public int binaryS(int[] arr, int x) {
		int left = -1, right = arr.length;
		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (arr[mid] < x) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return right;
	}
}
// @lc code=end



/*
// @lcpr case=start
// [[1,6],[3,7],[9,12],[4,13]]\n[2,3,7,11]\n
// @lcpr case=end

// @lcpr case=start
// [[1,10],[3,3]]\n[3,3,2]\n
// @lcpr case=end

 */

