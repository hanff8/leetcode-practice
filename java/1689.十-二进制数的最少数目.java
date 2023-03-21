/*
 * @lc app=leetcode.cn id=1689 lang=java
 * 
 * @lcpr version=21801
 *
 * [1689] 十-二进制数的最少数目
 */

// @lc code=start
class Solution {
    public int minPartitions(String n) {
        int ans = '0';
        for (int i = 0; i < n.length(); i++) {
            char ch = n.charAt(i);
            if (ch > ans)
                ans = ch;
        }
        return ans - '0';
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // "32"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "82734"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "27346209830709182346"\n // @lcpr case=end
 * 
 */


