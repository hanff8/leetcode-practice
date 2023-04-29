import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1027 lang=java
 * 
 * @lcpr version=21906
 *
 * [1027] 最长等差数列
 */

// @lc code=start
class Solution {
    private int[] arr;
    private int n;
    private Map<Integer, Integer>[] mapArr;
    private int ans;

    public int longestArithSeqLength(int[] nums) {
        n = nums.length;
        arr = nums;
        mapArr = new HashMap[n];
        for (int i = 1; i < n; i++) {
            dfs(i);
        }
        return ans;
    }

    public Map<Integer, Integer> dfs(int i) {
        if (mapArr[i] != null)
            return mapArr[i];
        mapArr[i] = new HashMap<>();
        for (int j = i - 1; j >= 0; j--) {
            int d = arr[i] - arr[j];
            if (!mapArr[i].containsKey(d)) {
                mapArr[i].put(d, dfs(j).getOrDefault(d, 1) + 1);
                ans = Math.max(ans, mapArr[i].get(d));
            }
        }
        return mapArr[i];
    }
}
// @lc code=end



/*
 * // @lcpr case=start // [3,6,9,12]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [9,4,7,2,10]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [20,1,15,3,10,5,8]\n // @lcpr case=end
 * 
 */

