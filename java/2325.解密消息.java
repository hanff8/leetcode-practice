import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=2325 lang=java
 * @lcpr version=21401
 *
 * [2325] 解密消息
 */

// @lc code=start
class Solution {
    public String decodeMessage(String key, String message) {
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<Character, Character> hashMap = new HashMap<>();
        int num = 0;
        for (int i = 0; i < key.length(); i++) {

            char ch = key.charAt(i);
            if (ch != ' ') {
                if (!hashMap.containsKey(ch)) {
                    hashMap.put(ch, (char) ('a' + num));
                    ++num;
                }
            }
        }

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (ch != ' ') {
                stringBuilder.append(hashMap.get(ch));
            } else {
                stringBuilder.append(' ');
            }
        }
        return stringBuilder.toString();
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "the quick brown fox jumps over the lazy dog"\n"vkbs bs t suepuv"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "eljuxhpwnyrdgtqkviszcfmabo"\n"zwx hnfx lqantp mnoeius ycgk vcnjrdb"\n
 * // @lcpr case=end
 * 
 */
