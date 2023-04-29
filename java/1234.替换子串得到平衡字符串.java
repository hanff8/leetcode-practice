import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1234 lang=java
 * 
 * @lcpr version=21505
 *
 * [1234] 替换子串得到平衡字符串
 */

// @lc code=start
class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int[] arr = new int['X'];
        for (char ch : s.toCharArray()) {
            arr[ch]++;
        }
        int m = n / 4;
        if (arr['Q'] == m && arr['W'] == m && arr['E'] == m && arr['R'] == m) {
            return 0;
        }
        int ans = n, left = 0;
        for (int right = 0; right < n; ++right) {
            // 保证子串外
            --arr[s.charAt(right)];
            while (arr['Q'] <= m && arr['W'] <= m && arr['E'] <= m && arr['R'] <= m) {
                ans = Math.min(ans, right - left + 1);
                ++arr[s.charAt(left++)];
            }
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
 * // @lcpr case=start // "QWER"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "QQWE"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "QQQW"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "QQQQ"\n // @lcpr case=end
 * 
 */
