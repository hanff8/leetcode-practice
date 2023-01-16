import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * @lc app=leetcode.cn id=1807 lang=java
 * @lcpr version=21107
 *
 * [1807] 替换字符串中的括号内容
 */

// @lc code=start
class Solution {
    // public String evaluate(String s, List<List<String>> knowledge) {
    // StringBuilder sb = new StringBuilder();
    // StringBuilder target = new StringBuilder();
    // HashMap<String, String> hashMap = new HashMap<String, String>();
    // for (List<String> list : knowledge) {
    // hashMap.put('(' + list.get(0) + ')', list.get(1));
    // }
    // int len = s.length();
    // boolean flag = false;
    // for (int i = 0; i < len; i++) {
    // char ch = s.charAt(i);
    // if (ch == '(')
    // flag = true;
    // if (ch == ')') {
    // flag = false;
    // target.append(ch);
    // sb.append(hashMap.getOrDefault(target.toString(), "?"));
    // target.setLength(0);
    // continue;
    // }
    // if (flag)
    // target.append(ch);
    // if (!flag)
    // sb.append(ch);

    // }
    // return sb.toString();
    // }
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (List<String> list : knowledge) {
            hashMap.put(list.get(0), list.get(1));
        }
        StringBuilder sb = new StringBuilder();
        String regex = "\\(([a-z]+)\\)";
        Pattern pa = Pattern.compile(regex);
        Matcher ma = pa.matcher(s);
        while (ma.find()) {
            String key = ma.group(1);
            String val = hashMap.getOrDefault(key, "?");
            ma.appendReplacement(sb, val);
        }
        ma.appendTail(sb);
        return sb.toString();
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "(name)is(age)yearsold"\n[["name","bob"],["age","two"]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "hi(name)"\n[["a","b"]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "(a)(a)(a)aaa"\n[["a","yes"]]\n
 * // @lcpr case=end
 * 
 */
