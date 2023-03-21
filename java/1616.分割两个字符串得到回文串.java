/*
 * @lc app=leetcode.cn id=1616 lang=java
 * 
 * @lcpr version=21801
 *
 * [1616] 分割两个字符串得到回文串
 */

// @lc code=start
class Solution {
    public boolean check1(String a, String b) {
        int n = a.length();
        int start = 0, end = n - 1;
        while (start < end && a.charAt(start) == b.charAt(end)) {
            start++;
            end--;
        }
        return isPalindrome(a, start, end) || isPalindrome(b, start, end);
    }

    private boolean isPalindrome(String str, int i, int j) {
        while (i < j && str.charAt(i) == str.charAt(j)) {
            i++;
            j--;
        }
        return i >= j;
    }

    public boolean checkPalindromeFormation(String a, String b) {
        return check1(a, b) || check1(b, a);

    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // "x"\n"y"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "abdef"\n"fecab"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "ulacfd"\n"jizalu"\n // @lcpr case=end
 * 
 */


