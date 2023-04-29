import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=2418 lang=java
 * 
 * @lcpr version=21907
 *
 * [2418] 按身高排序
 */

// @lc code=start
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        Arrays.sort(arr, (a, b) -> heights[b] - heights[a]);

        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = names[arr[i]];
        }
        return res;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // ["Mary","John","Emma"]\n[180,165,170]\n // @lcpr case=end
 * 
 * // @lcpr case=start // ["Alice","Bob","Bob"]\n[155,185,150]\n // @lcpr case=end
 * 
 */

