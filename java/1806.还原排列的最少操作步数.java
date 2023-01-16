import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode.cn id=1806 lang=java
 * @lcpr version=21105
 *
 * [1806] 还原排列的最少操作步数
 */

// @lc code=start
class Solution {
    public int reinitializePermutation(int n) {
        int[] target = new int[n];
        int[] perm = new int[n];
        for (int i = 0; i < perm.length; i++) {
            perm[i] = i;
            target[i] = i;
        }
        int num = 0;
        boolean flag = true;
        while (true) {
            flag = true;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }
            }
            perm = arr;
            ++num;
            if (Arrays.equals(target, perm)) {
                break;
            }
        }
        return num;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 4\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 6\n
 * // @lcpr case=end
 * 
 */
