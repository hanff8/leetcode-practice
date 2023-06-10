/*
 * @lc app=leetcode.cn id=424 lang=java
 * 
 * @lcpr version=21909
 *
 * [424] 替换后的最长重复字符
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] map = new int['Z' + 1];
        int res = 0, maxCount = 0, right = 0, left = 0;
        char[] chs = s.toCharArray();
        for (; right < n;) {
            map[chs[right]]++;
            maxCount = Math.max(maxCount, map[chs[right]]);
            right++;
            if (right - left > maxCount + k) {
                //说明超出能替换的k的范围
                map[chs[left]]--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "ABAB"\n2\n
// @lcpr case=end

// @lcpr case=start
// "AABABBA"\n1\n
// @lcpr case=end

 */

