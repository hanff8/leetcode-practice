/*
 * @lc app=leetcode.cn id=1177 lang=java
 * 
 * @lcpr version=21909
 *
 * [1177] 构建回文串检测
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayDeque;

// @lc code=start
class Solution {
    // 时间复杂度 (n+26)*q
    // public boolean isPalindrome(char[] chs, int num) {
    //     int n = chs.length;
    //     if (n == 1)
    //         return true;
    //     int[] arr = new int[26];

    //     for (int i = 0; i < n; i++) {
    //         arr[chs[i] - 'a']++;
    //     }
    //     int res = 0;
    //     for (int i = 0; i < arr.length; i++) {
    //         if (arr[i] == 0)
    //             continue;
    //         if (arr[i] % 2 != 0) {
    //             res += arr[i] % 2;
    //         }
    //     }
    //     return res % 2 == 0 ? res / 2 <= num : (res - 1) / 2 <= num;
    // }

    // public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
    //     List<Boolean> res = new ArrayList<>();
    //     for (int[] q : queries) {
    //         char[] chs = s.substring(q[0], q[1] + 1).toCharArray();
    //         int num = q[2];
    //         // Arrays.sort(chs);
    //         // System.out.println(Arrays.toString(chs));
    //         res.add(isPalindrome(chs, num));
    //     }
    //     return res;
    // }
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int bits = 1 << (s.charAt(i) - 'a');
            sum[i + 1] = sum[i] ^ bits;
        }
        List<Boolean> res = new ArrayList<>(queries.length);
        for (var q : queries) {
            int left = q[0], right = q[1], k = q[2], m = 0;
            m = Integer.bitCount(sum[right + 1] ^ sum[left]);
            res.add(m / 2 <= k);
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "abcda"\n[[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]\n
// @lcpr case=end

 */

