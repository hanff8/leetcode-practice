/*
 * @lc app=leetcode.cn id=2496 lang=java
 * 
 * @lcpr version=21909
 *
 * [2496] 数组中字符串的最大值
 */

// @lc code=start
class Solution {
    public int maximumValue(String[] strs) {
        int res = 0;
        boolean flag = true;
        for (String str : strs) {
            flag = true;
            for (char c : str.toCharArray()) {
                if (Character.isAlphabetic(c)) {
                    res = Math.max(res, str.length());
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res = Math.max(res, Integer.parseInt(str));
            }
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// ["alic3","bob","3","4","00000"]\n
// @lcpr case=end

// @lcpr case=start
// ["1","01","001","0001"]\n
// @lcpr case=end

 */

