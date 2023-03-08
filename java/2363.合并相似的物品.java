import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.validation.Validator;

/*
 * @lc app=leetcode.cn id=2363 lang=java
 * @lcpr version=21707
 *
 * [2363] 合并相似的物品
 */

// @lc code=start
class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int[] is : items2) {
            map.put(is[0], map.getOrDefault(is[0], 0) + is[1]);
        }
        for (int[] is : items1) {
            map.put(is[0], map.getOrDefault(is[0], 0) + is[1]);
        }
        List<List<Integer>> re = new ArrayList<>();

        map.forEach((a, b) -> {
            List<Integer> temp = new ArrayList<>();
            temp.add(a);
            temp.add(b);
            re.add(temp);
        });
        Collections.sort(re, (a, b) -> {
            return a.get(0) - b.get(0);
        });
        return re;
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end

/*
 * // @lcpr case=start
 * // [[1,1],[4,5],[3,8]]\n[[3,1],[1,5]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[1,1],[3,2],[2,3]]\n[[2,1],[3,2],[1,3]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[1,3],[2,2]]\n[[7,1],[2,2],[1,4]]\n
 * // @lcpr case=end
 * 
 */
