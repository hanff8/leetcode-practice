import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1234 lang=java
 * @lcpr version=21505
 *
 * [1234] 替换子串得到平衡字符串
 */

// @lc code=start
class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int m = n / 4;
        int left = 0, right = 0;
        var chs = s.toCharArray();
        int[] arr = new int['X'];
        // 先统计字符串中每个字符出现的次数
        for (char chs2 : chs) {
            arr[chs2]++;
        }
        int ans = n;
        if (arr['Q'] == m && arr['W'] == m && arr['E'] == m && arr['R'] == m)
            return 0;
        for (right = 0; right < n; ++right) {
            --arr[chs[right]];
            System.out.println(arr[chs[right]]);
            while (arr['Q'] <= m && arr['W'] <= m && arr['E'] <= m && arr['R'] <= m) {
                ans = Math.min(ans, right - left + 1);
                ++arr[chs[left++]]; // 缩小子串
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
 * // @lcpr case=start
 * // "QWER"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "QQWE"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "QQQW"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "QQQQ"\n
 * // @lcpr case=end
 * 
 */
