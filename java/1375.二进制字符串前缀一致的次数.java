/*
 * @lc app=leetcode.cn id=1375 lang=java
 * 
 * @lcpr version=21909
 *
 * [1375] 二进制字符串前缀一致的次数
 */

// @lc code=start
class Solution {
    public int numTimesAllBlue(int[] flips) {
        int right = 0, n = flips.length, res = 0;
        for (int i = 0; i < n; i++) {
            right = Math.max(right, flips[i]);
            if (right == i + 1)
                res++;
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,2,4,1,5]\n
// @lcpr case=end

// @lcpr case=start
// [4,1,2,3]\n
// @lcpr case=end

 */

