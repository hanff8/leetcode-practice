/*
 * @lc app=leetcode.cn id=1250 lang=java
 * @lcpr version=21505
 *
 * [1250] 检查「好数组」
 */

// @lc code=start
class Solution {
    public boolean isGoodArray(int[] nums) {
        int divisor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            divisor = gcd(divisor, nums[i]);
            if (divisor == 1)
                break;
        }
        return divisor == 1;
    }

    // public int gcd(int a, int b) {
    // while (b != 0) {
    // int temp = a;
    // a = b;
    // b = temp % b;
    // }
    // return a;
    // }
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end

/*
 * // @lcpr case=start
 * // [12,5,7,23]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [29,6,10]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [3,6]\n
 * // @lcpr case=end
 * 
 */
