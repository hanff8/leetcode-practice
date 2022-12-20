import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1703 lang=java
 * @lcpr version=21103
 *
 * [1703] 得到连续 K 个 1 的最少相邻交换次数
 */

// @lc code=start
class Solution {
    public int minMoves(int[] nums, int k) {

        // 取出所有的1
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                arr.add(i - arr.size());
            }
        }

        // 构建前缀和数组
        int[] pre = new int[arr.size() + 1];
        for (int i = 0; i < arr.size(); i++) {
            pre[i + 1] = pre[i] + arr.get(i);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= arr.size() - k; i++) {
            ans = Math.min(ans, pre[i] + pre[i + k] - pre[i + k / 2] * 2 - arr.get(i + k / 2) * (k % 2));
        }
        return ans;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,0,0,1,0,1]\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,0,0,0,0,0,1,1]\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,1,0,1]\n2\n
 * // @lcpr case=end
 * 
 */
