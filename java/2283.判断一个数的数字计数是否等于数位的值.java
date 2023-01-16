import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2283 lang=java
 * @lcpr version=21105
 *
 * [2283] 判断一个数的数字计数是否等于数位的值
 */

// @lc code=start
class Solution {
    public boolean digitCount(String num) {
        int[] arr = new int[10];
        for (int i = 0; i < num.length(); i++) {
            int val = num.charAt(i) - '0';
            arr[val]++;
        }
        for (int i = 0; i < num.length(); i++) {
            int val = num.charAt(i) - '0';
            if (arr[i] != val)
                return false;
        }
        return true;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "1210"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "030"\n
 * // @lcpr case=end
 * 
 */
