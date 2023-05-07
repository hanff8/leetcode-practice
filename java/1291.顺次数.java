/*
 * @lc app=leetcode.cn id=1291 lang=java
 * 
 * @lcpr version=21907
 *
 * [1291] 顺次数
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; ++i) {
            int num = i;
            for (int j = i + 1; j <= 9; j++) {
                num = num * 10 + j;
                if (num >= low && num <= high) {
                    list.add(num);
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}
// @lc code=end


