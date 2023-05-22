/*
 * @lc app=leetcode.cn id=1079 lang=java
 * 
 * @lcpr version=21908
 *
 * [1079] 活字印刷
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
    // private static final int MX = 8;
    // private static final int[][] c = new int[MX][MX];

    // static {
    //     for (int i = 0; i < MX; i++) {
    //         c[i][0] = c[i][i] = 1;
    //         for (int j = 1; j < i; j++)
    //             c[i][j] = c[i - 1][j - 1] + c[i - 1][j]; // 预处理组合数
    //     }
    // }

    // public int numTilePossibilities(String tiles) {
    //     // 注：改成 int[26] 统计可能会快一点点，感兴趣可以试试（下面 DP 跳过 cnt=0 的情况）
    //     var counts = new HashMap<Character, Integer>(); // 统计每个字母的出现次数
    //     for (var c : tiles.toCharArray())
    //         counts.merge(c, 1, Integer::sum); // counts[c]++
    //     var f = new int[tiles.length() + 1];
    //     f[0] = 1; // 构造空序列的方案数
    //     int n = 0;
    //     for (var cnt : counts.values()) { // 枚举第 i 种字母
    //         n += cnt; // 常数优化：相比从 tiles.length() 开始要更快
    //         for (int j = n; j > 0; j--) // 枚举序列长度 j
    //             // 枚举第 i 种字母选了 k 个，注意 k=0 时的方案数已经在 f[j] 中了
    //             for (int k = 1; k <= j && k <= cnt; k++)
    //                 f[j] += f[j - k] * c[j][k];
    //     }
    //     int ans = 0;
    //     for (int j = 1; j <= n; j++)
    //         ans += f[j];
    //     return ans;
    // }
    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> map = new HashMap<>();
        for (var ch : tiles.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        Set<Character> tile = new HashSet<>(map.keySet());
        return dfs(tiles.length(), map, tile) - 1;

    }

    private int dfs(int i, Map<Character, Integer> map, Set<Character> tile) {
        if (i == 0)
            return 1;
        int res = 1;
        for (char t : tile) {
            if (map.get(t) > 0) {
                map.put(t, map.get(t) - 1);
                res += dfs(i - 1, map, tile);
                map.put(t, map.get(t) + 1);
            }
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "AAB"\n
// @lcpr case=end

// @lcpr case=start
// "AAABBC"\n
// @lcpr case=end

// @lcpr case=start
// "V"\n
// @lcpr case=end

 */

