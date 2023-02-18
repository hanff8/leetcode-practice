import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=2341 lang=java
 * @lcpr version=21601
 *
 * [2341] 数组能形成多少数对
 */

// @lc code=start
class Solution {
    public int[] numberOfPairs(int[] nums) {

        var map = new HashMap<Integer, Boolean>();
        int ans = 0;
        for (int i : nums) {
            map.put(i, !map.getOrDefault(i, false));
            if (!map.get(i))
                ans++;
        }
        return new int[] { ans, nums.length - ans * 2 };
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
 * // [1,3,2,1,3,2,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0]\n
 * // @lcpr case=end
 * 
 */
