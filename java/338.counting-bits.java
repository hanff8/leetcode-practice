/*
 * @lc app=leetcode.cn id=338 lang=java
 * 
 * @lcpr version=21917
 *
 * [338] 比特位计数
 */

// @lc code=start


class Solution {
	public int[] countBits(int n) {
		// return solution1(n);
		return solution2(n);
	}

	private int[] solution2(int n) {
		int[] res = new int[n + 1];
		int highBit = 0;
		for (int i = 1; i <= n; i++) {
			if ((i & i - 1) == 0) {
				highBit = i;
			}
			res[i] = res[i - highBit] + 1;
		}
		return res;
	}

	private int[] solution3(int n) {
		int[] res = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			res[i] = res[i >> 1] + (i & 1);
		}
		return res;
	}

	private int[] solution4(int n) {
		int[] res = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			// i&(i-1)!=0 则将i的最低为1,变成0; 如果i&(i-1)==0说明是2的n次幂，直接给1；
			res[i] = res[i & (i - 1)] + 1;
		}
		return res;
	}


	private int[] solution1(int n) {
		int[] res = new int[n + 1];
		for (int i = 0; i < res.length; i++) {
			res[i] = count(i);
		}
		return res;
	}

	private int count(int num) {
		int ones = 0;
		while (num > 0) {
			num = num & (num - 1);
			ones++;
		}
		return ones;
	}
}
// @lc code=end



/*
// @lcpr case=start
// 2\n
// @lcpr case=end

// @lcpr case=start
// 5\n
// @lcpr case=end

 */

