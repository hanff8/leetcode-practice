//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 6848 👎 0


package leetcode.editor.cn;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            if (n < 2) return s;
            boolean[][] dp = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = true;
            }
            int begin = 0, maxLen = 1;
            char[] chs = s.toCharArray();
            for (int Len = 2; Len <= n; Len++) {
                for (int left = 0; left < n; left++) {
                    int right = left + Len - 1;
                    if (right >= n) break;
                    if (chs[left] != chs[right]) {
                        dp[left][right] = false;
                    } else {
                        // 中间只有1个或0个字符
                        if (right - left < 3) {
                            dp[left][right] = true;
                        } else {
                            dp[left][right] = dp[left + 1][right - 1];
                        }
                    }
                    if (dp[left][right] && right - left + 1 > maxLen) {
                        maxLen = right - left + 1;
                        begin = left;
                    }
                }
            }

            return s.substring(begin, begin + maxLen);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
