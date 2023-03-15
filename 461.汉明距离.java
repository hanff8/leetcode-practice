import java.math.BigInteger;

/*
 * @lc app=leetcode.cn id=461 lang=java
 * 
 * @lcpr version=21801
 *
 * [461] 汉明距离
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        // int ans = 0;
        // int s = x ^ y;
        // while (s != 0) {
        // ans += s & 1;
        // s >>= 1;
        // }
        // return ans;
        return Integer.bitCount(x ^ y);
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // 1\n4\n // @lcpr case=end
 * 
 * // @lcpr case=start // 3\n1\n // @lcpr case=end
 * 
 */


