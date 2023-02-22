/*
 * @lc app=leetcode.cn id=509 lang=java
 * 
 * @lcpr version=21704
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {
    public int fibn(int n) {
        if (n < 2)
            return n;
        return fibn(n - 2) + fib(n - 1);
    }

    public int fib(int n) {
        // int[] f = new int[2];
        // if (n == 0 || n == 1) {
        // return n;
        // }

        // f[0] = 0;
        // f[1] = 1;
        // for (int i = 2; i <= n; i++) {
        // int sum = f[0] + f[1];
        // f[0] = f[1];
        // f[1] = sum;
        // }
        // return f[1];
        return fibn(n);
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // 2\n // @lcpr case=end
 * 
 * // @lcpr case=start // 3\n // @lcpr case=end
 * 
 * // @lcpr case=start // 4\n // @lcpr case=end
 * 
 */


