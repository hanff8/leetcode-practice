import java.util.Collections;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=2347 lang=java
 * 
 * @lcpr version=21704
 *
 * [2347] 最好的扑克手牌
 */

// @lc code=start
class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        var map1 = new HashMap<Character, Integer>();
        for (char c : suits) {
            int a = map1.getOrDefault(c, 0);
            map1.put(c, a + 1);
            if (a + 1 == 5)
                return "Flush";
        }
        var map2 = new HashMap<Integer, Integer>();
        int num = -1;
        for (int c : ranks) {
            int a = map2.getOrDefault(c, 0);
            map2.put(c, a + 1);
            if (num < a + 1)
                num = a + 1;
        }
        if (num >= 3)
            return "Three of a Kind";
        if (num >= 2)
            return "Pair";

        return "High Card";
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // [13,2,3,1,9]\n["a","a","a","a","a"]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [4,4,2,4,4]\n["d","a","a","b","c"]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [10,10,2,12,9]\n["a","b","c","a","d"]\n // @lcpr case=end
 * 
 */


