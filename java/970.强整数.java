/*
 * @lc app=leetcode.cn id=970 lang=java
 * 
 * @lcpr version=21907
 *
 * [970] 强整数
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        // if (x == 1 && y == 1 && bound > 2) {
        // list.add(2);
        // return list;
        // }
        for (int i = 1; i < bound; i *= x) {
            for (int j = 1; j + i <= bound; j *= y) {
                set.add(i + j);
                if (y == 1)
                    break;
            }
            if (x == 1)
                break;

        }
        // for (int val : set) {
        // list.add(val);
        // }
        return new ArrayList<>(set);
    }
}
// @lc code=end



/*
 * // @lcpr case=start // 2\n3\n10\n // @lcpr case=end
 * 
 * // @lcpr case=start // 3\n5\n15\n // @lcpr case=end
 * 
 */

