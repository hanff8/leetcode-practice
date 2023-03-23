/*
 * @lc app=leetcode.cn id=2079 lang=java
 * 
 * @lcpr version=21801
 *
 * [2079] 给植物浇水
 */

// @lc code=start
class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int index = 0, ans = 0, cap = capacity;
        while (index < plants.length) {
            if (plants[index] <= cap) {
                cap -= plants[index];
                index++;
                ans++;
            } else {
                ans += index * 2;
                cap = capacity;
            }
        }
        return ans;
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // [2,2,3,3]\n5\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1,1,1,4,2,3]\n4\n // @lcpr case=end
 * 
 * // @lcpr case=start // [7,7,7,7,7,7,7]\n8\n // @lcpr case=end
 * 
 */


