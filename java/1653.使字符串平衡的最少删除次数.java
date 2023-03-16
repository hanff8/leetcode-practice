/*
 * @lc app=leetcode.cn id=1653 lang=java
 * 
 * @lcpr version=21801
 *
 * [1653] 使字符串平衡的最少删除次数
 */

// @lc code=start
class Solution {
    public int minimumDeletions(String S) {
        var s = S.toCharArray();
        int del = 0;
        for (var c : s)
            del += 'b' - c; // 统计 'a' 的个数
        int ans = del;
        for (var c : s) {
            // 'a' -> -1 'b' -> 1
            del += (c - 'a') * 2 - 1;
            ans = Math.min(ans, del);
        }
        return ans;
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // "aababbab"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "bbaaaaabb"\n // @lcpr case=end
 * 
 */


