/*
 * @lc app=leetcode.cn id=1881 lang=java
 * @lcpr version=21801
 *
 * [1881] 插入后的最大值
 */

// @lc code=start
class Solution {
    public String maxValue(String n, int x) {
        int pos = 0;
        if (n.charAt(0) != '-') {
            for (int i = 0; i < n.length(); i++) {
                if (n.charAt(i) - '0' < x) {
                    return n.substring(0, i) + x + n.substring(i);
                }
            }
        } else {
            for (int i = 1; i < n.length(); i++) {
                if (n.charAt(i) - '0' > x) {

                    return n.substring(0, i) + x + n.substring(i);
                }
            }
        }
        return n + x;
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
 * // "99"\n9\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "-13"\n2\n
 * // @lcpr case=end
 * 
 */
