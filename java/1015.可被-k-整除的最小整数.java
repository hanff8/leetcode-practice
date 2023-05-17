/*
 * @lc app=leetcode.cn id=1015 lang=java
 * 
 * @lcpr version=21907
 *
 * [1015] 可被 K 整除的最小整数
 */

// @lc code=start
class Solution {
    public int smallestRepunitDivByK(int k) {
        // 算法一
        // int resid = 1 % k, len = 1; // resid为余数，len为数字长度，初始值为1
        // Set<Integer> set = new HashSet<Integer>(); // 创建一个无序集合，用于存储余数
        // set.add(resid); // 插入余数1
        // while (resid != 0) { // 当余数为0时退出循环
        // resid = (resid * 10 + 1) % k; // 计算下一个余数
        // len++; // 数字长度+1
        // if (set.contains(resid)) { // 如果余数重复出现，则无解
        // return -1;
        // }
        // set.add(resid); // 将余数插入集合
        // }
        // return len; // 返回数字长度

        // 算法二
        if (k % 2 == 0 || k % 5 == 0)
            return -1;
        int x = 1 % k;
        for (int i = 1;; i++) {
            if (x == 0)
                return i;
            x = (x * 10 + 1) % k;
        }
    }
}
// @lc code=end



/*
 * // @lcpr case=start // 1\n // @lcpr case=end
 * 
 * // @lcpr case=start // 2\n // @lcpr case=end
 * 
 * // @lcpr case=start // 3\n // @lcpr case=end
 * 
 */

