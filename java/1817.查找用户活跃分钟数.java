import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1817 lang=java
 * @lcpr version=21108
 *
 * [1817] 查找用户活跃分钟数
 */

// @lc code=start
class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> activeMinutes = new HashMap<>();
        for (int[] is : logs) {
            int id = is[0], time = is[1];
            activeMinutes.putIfAbsent(id, new HashSet<Integer>());
            activeMinutes.get(id).add(time);
        }
        int[] answer = new int[k];
        for (Set<Integer> s : activeMinutes.values()) {
            int activeCount = s.size();
            answer[activeCount - 1]++;
        }

        return answer;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[0,5],[1,2],[0,2],[0,5],[1,3]]\n5\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[1,1],[2,2],[2,3]]\n4\n
 * // @lcpr case=end
 * 
 */
