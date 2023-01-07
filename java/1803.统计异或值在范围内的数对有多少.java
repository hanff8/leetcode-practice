/*
 * @lc app=leetcode.cn id=1803 lang=java
 * @lcpr version=21105
 *
 * [1803] 统计异或值在范围内的数对有多少
 */

// @lc code=start
class Solution {
    // int n = 0;
    // for (int i = 0; i < nums.length; i++) {
    // for (int j = i + 1; j < nums.length; j++) {
    // if ((nums[i] ^ nums[j]) <= high && (nums[i] ^ nums[j]) >= low) {
    // ++n;
    // }
    // }
    // }
    // return n;
    private Trie root = null;
    private static final int HIGH_BIT = 16;

    public int countPairs(int[] nums, int lows, int high) {
        return f(nums, high) - f(nums, lows - 1);
    }

    public int f(int[] nums, int x) {
        root = new Trie();
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            add(nums[i - 1]);
            res += get(nums[i], x);
        }
        return res;
    }

    public void add(int num) {
        Trie cur = root;
        for (int k = HIGH_BIT; k >= 0; k--) {
            int bit = (num >> k) & 1;
            if (cur.son[bit] == null) {
                cur.son[bit] = new Trie();
            }
            cur = cur.son[bit];
            cur.sum++;
        }
    }

    public int get(int num, int x) {
        Trie cur = root;
        int sum = 0;
        for (int k = HIGH_BIT; k >= 0; k--) {
            int r = (num >> k) & 1;
            if (((x >> k) & 1) != 0) {
                if (cur.son[r] != null) {
                    sum += cur.son[r].sum;
                }
                if (cur.son[r ^ 1] == null) {
                    return sum;
                }
                cur = cur.son[r ^ 1];
            } else {
                if (cur.son[r] == null) {
                    return sum;
                }
                cur = cur.son[r];
            }
        }
        sum += cur.sum;
        return sum;
    }

}

class Trie {
    // son[0] 左子树, son[1] 右子树
    Trie[] son = new Trie[2];
    int sum;

    public Trie() {
        sum = 0;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,4,2,7]\n2\n6\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [9,8,4,2,1]\n5\n14\n
 * // @lcpr case=end
 * 
 */
