/*
 * @lc app=leetcode.cn id=831 lang=java
 * 
 * @lcpr version=21901
 *
 * [831] 隐藏个人信息
 */

// @lc code=start
class Solution {
    public String maskPII(String s) {
        int pos = s.indexOf('@');
        s = s.toLowerCase();
        if (pos != -1) {
            // String name = s.substring(0, pos).toLowerCase();
            // String maskName = name.charAt(0) + "*".repeat(5) + name.charAt(name.length() - 1);
            // String domain = s.substring(pos).toLowerCase();
            // return maskName + domain;
            return s.charAt(0) + "*****" + s.substring(pos - 1).toLowerCase();
        } else {
            // String numberPure = s.replaceAll("-|\\(|\\)|\\+|\\s", "");
            String numberPure = s.replaceAll("[^0-9]", "");
            System.out.println(numberPure);
            int n1 = numberPure.length();
            // String base = String.join("-", "***", "***", numberPure.substring(n1 - 4));
            String[] country = new String[] {"", "+*-", "+**-", "+***-"};
            return country[n1 - 10] + "***-***-" + numberPure.substring(n1 - 4);
        }
    }
}
// @lc code=end



/*
 * // @lcpr case=start // "LeetCode@LeetCode.com"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "AB@qq.com"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "1(234)567-890"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "86-(10)12345678"\n // @lcpr case=end
 * 
 */


