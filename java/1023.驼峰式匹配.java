import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1023 lang=java
 * 
 * @lcpr version=21906
 *
 * [1023] 驼峰式匹配
 */

// @lc code=start
class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        int n = queries.length;
        for (int i = 0; i < n; i++) {
            String str = queries[i];
            boolean flag = true;
            int k = 0;
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (pattern.length() > k && pattern.charAt(k) == ch) {
                    k++;
                } else if (Character.isUpperCase(ch)) {
                    flag = false;
                    break;
                }
            }
            if (k < pattern.length()) {
                flag = false;
            }
            ans.add(flag);
        }
        return ans;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"]\n"FB"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start // ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"]\n"FoBa"\n
 * // @lcpr case=end
 * 
 */

