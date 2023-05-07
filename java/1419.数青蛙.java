/*
 * @lc app=leetcode.cn id=1419 lang=java
 * 
 * @lcpr version=21907
 *
 * [1419] 数青蛙
 */

// @lc code=start
class Solution {
    // 记录每一个字符的前一个字符
    private static final char[] previous = new char['s'];
    static {
        var chs = "croakc".toCharArray();
        for (int i = 1; i < chs.length; i++) {
            previous[chs[i]] = chs[i - 1];
        }
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] cnt = new int['s'];
        for (char ch : croakOfFrogs.toCharArray()) {
            var pre = previous[ch];
            if (cnt[pre] > 0) {
                cnt[pre]--;
            } else if (ch != 'c') {
                return -1;
            }
            cnt[ch]++;
        }
        if (cnt['c'] > 0 || cnt['r'] > 0 || cnt['o'] > 0 || cnt['a'] > 0) {
            return -1;
        }
        return cnt['k'];
    }
}
// @lc code=end



/*
 * // @lcpr case=start // "croakcroak"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "crcoakroak"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "croakcrook"\n // @lcpr case=end
 * 
 */

