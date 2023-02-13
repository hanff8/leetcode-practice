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
        Map<Character, Integer> hashmap = new HashMap<>();
        hashmap.put('Q', 0);
        hashmap.put('R', 0);
        hashmap.put('W', 0);
        hashmap.put('E', 0);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            hashmap.put(s.charAt(i), hashmap.get(s.charAt(i)) + 1);
        }
        int times = s.length() / 4;
        System.out.println("length:" + s.length() + " times:" + times);
        for (var val : hashmap.entrySet()) {
            System.out.println(val.getKey() + ":" + val.getValue());
            if (val.getValue() != times) {
                res += val.getValue() - times;
            }
        }
        return res;
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
