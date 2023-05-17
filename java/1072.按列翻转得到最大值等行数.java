/*
 * @lc app=leetcode.cn id=1072 lang=java
 * 
 * @lcpr version=21907
 *
 * [1072] 按列翻转得到最大值等行数
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;

// @lc code=start
class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            char[] chs = new char[n];
            Arrays.fill(chs, '0');
            for (int j = 0; j < chs.length; j++) {
                //如果开头为0的话，经过 '0' + matrix[i][j] ^ matrix[i][0] 序列不会有变化
                //如果开头为1的话，讲过'0' + matrix[i][j] ^ matrix[i][0]，序列会翻转
                chs[j] = (char) ('0' + matrix[i][j] ^ matrix[i][0]);
            }
            String s = new String(chs);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int res = 0;
        for (var entry : map.entrySet()) {
            res = Math.max(entry.getValue(), res);
        }
        return res;
    }
}
/**
 * 0 1 1 1
 * 
 * 0 1 1 0
 * 
 * 
 * 
 * 
 * 0 0 0 0 0 1 1 1 0
 * 
 * 1 1 1
 * 
 * 1 1 0
 * 
 * 1 1 0
 */
// @lc code=end



/*
 * // @lcpr case=start // [[0,1],[1,1]]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [[0,1],[1,0]]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [[0,0,0],[0,0,1],[1,1,0]]\n // @lcpr case=end
 * 
 */

