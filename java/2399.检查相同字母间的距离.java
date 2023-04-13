/*
 * @lc app=leetcode.cn id=2399 lang=java
 * 
 * @lcpr version=21902
 *
 * [2399] 检查相同字母间的距离
 */

// @lc code=start
class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int n = s.length();
        for (int left = 0; left < n; left++) {
            int dis = 0;
            int right = left + 1;
            if (distance[s.charAt(left) - 'a'] == -1)
                continue;
            while (right < n && s.charAt(left) != s.charAt(right)) {
                right++;
                dis++;
            }
            System.out.println(dis + " " + s.charAt(left));
            if (distance[s.charAt(left) - 'a'] != dis)
                return false;
            distance[s.charAt(left) - 'a'] = -1;

        }
        return true;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // "abaccb"\n[1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]\n // @lcpr
 * case=end
 * 
 * // @lcpr case=start // "aa"\n[1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]\n // @lcpr
 * case=end
 * 
 */


