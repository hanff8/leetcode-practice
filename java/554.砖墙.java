import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=554 lang=java
 * 
 * @lcpr version=21906
 *
 * [554] 砖墙
 */

// @lc code=start
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int tmp = 0;
            for (int val : list) {
                tmp += val;
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
            map.remove(tmp);
        }
        int n = wall.size();
        int max = n;
        for (var val : map.keySet()) {
            int cnt = map.get(val);
            max = Math.min(max, n - cnt);
        }
        return max;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [[1],[1],[1]]\n // @lcpr case=end
 * 
 */

