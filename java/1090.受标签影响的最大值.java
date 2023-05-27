/*
 * @lc app=leetcode.cn id=1090 lang=java
 * 
 * @lcpr version=21908
 *
 * [1090] 受标签影响的最大值
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayDeque;
// @lc code=start


class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        Integer[] id = new Integer[n];
        for (int i = 0; i < n; ++i) {
            id[i] = i;
        }
        //把下标按values值的降序排列
        Arrays.sort(id, (a, b) -> values[b] - values[a]);
        // System.out.println(Arrays.toString(id));
        int ans = 0, choose = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n && choose < numWanted; i++) {
            int lable = labels[id[i]];
            //使用限制
            if (map.getOrDefault(lable, 0) == useLimit) {
                continue;
            }
            ++choose;
            ans += values[id[i]];
            map.put(lable, map.getOrDefault(lable, 0) + 1);
        }
        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [5,4,3,2,1]\n[1,1,2,2,3]\n3\n1\n
// @lcpr case=end

// @lcpr case=start
// [5,4,3,2,1]\n[1,3,3,3,2]\n3\n2\n
// @lcpr case=end

// @lcpr case=start
// [9,8,8,7,6]\n[0,0,0,1,1]\n3\n1\n
// @lcpr case=end

 */

