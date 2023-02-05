import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=1798 lang=java
 * @lcpr version=21401
 *
 * [1798] 你能构造出连续值的最大数目
 */
/**
 * 
 * 那么我们可以构造出的区间为 [0,x]和 [y, x + y]，那么如果 y <= x+1，则加入整数 y
 * 后我们能构造出 [0, x + y] 区间的整数，否则我们还是只能构造出 [0, x]区间的数字
 * 
 **/
// @lc code=start
class Solution {
    public int getMaximumConsecutive(int[] coins) {
        int res = 1;
        Arrays.sort(coins);

        for (int i : coins) {
            if (i > res) {
                break;
            }
            res += i;
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,1,1,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,4,10,3,1]\n
 * // @lcpr case=end
 * 
 */
