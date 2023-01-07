/*
 * @lc app=leetcode.cn id=2180 lang=java
 * @lcpr version=21105
 *
 * [2180] 统计各位数字之和为偶数的整数个数
 */

// @lc code=start
class Solution {
    public int countEven(int num) {
        if (num < 10) {
            return num / 2;
        }
        int count = 4;
        for (int i = 10; i <= num; ++i) {
            int sum = 0;
            int number = i;
            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }
            if (sum % 2 != 0)
                continue;
            ++count;
            System.out.println(sum + " " + i);
        }
        return count;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 4\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 30\n
 * // @lcpr case=end
 * 
 */
