import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1785 lang=java
 * @lcpr version=21103
 *
 * [1785] 构成特定和需要添加的最少元素
 */

// @lc code=start
class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long res = 0;
        for (int i : nums) {
            res+=i;
        }
        long gap = Math.abs(res-goal);

        return (int)((gap+limit-1)/limit); 

    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,-1,1]\n3\n-4\n
// @lcpr case=end

// @lcpr case=start
// [1,-10,9,1]\n100\n0\n
// @lcpr case=end

 */


