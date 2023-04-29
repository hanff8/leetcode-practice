import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=20 lang=java
 * 
 * @lcpr version=21906
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        int n = s.length();

        Deque<Character> deque = new ArrayDeque<>();
        Map<Character, Character> map = Map.of('(', ')', '[', ']', '{', '}');

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                deque.push(map.get(ch));
            } else {
                if (deque.isEmpty() || deque.pop() != ch)
                    return false;
            }
        }
        if (deque.isEmpty())
            return true;
        return false;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // "()"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "()[]{}"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "(]"\n // @lcpr case=end
 * 
 */

