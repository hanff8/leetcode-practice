import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=118 lang=java
 * 
 * @lcpr version=21906
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(List.of(1)));
        if (numRows == 1)
            return list;
        list.add(new ArrayList<>(List.of(1, 1)));
        for (int i = 2; i < numRows; i++) {
            var row = new ArrayList<Integer>();
            row.add(1);
            int j = 1;
            while (j < i) {
                row.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                j++;
            }
            row.add(1);
            list.add(row);
        }
        return list;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // 5\n // @lcpr case=end
 * 
 * // @lcpr case=start // 1\n // @lcpr case=end
 * 
 */

