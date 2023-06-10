/*
 * @lc app=leetcode.cn id=2517 lang=java
 * 
 * @lcpr version=21908
 *
 * [2517] 礼盒的最大甜蜜度
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
    // 二分 >x 最小值中的最大值
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        // left 最小的绝对值，right 最大的绝对值 left 取不到，所以是左开右闭区间
        int left = 0, right = price[price.length - 1] - price[0] + 1;
        while (left + 1 < right) {
            // mid 获取一个中间偏右的值
            int mid = left + (right - left) / 2;
            if (check(price, k, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public boolean check(int[] price, int k, int tastiness) {
        int prev = Integer.MIN_VALUE / 2;
        int cnt = 0;
        for (int p : price) {
            if (p - prev >= tastiness) {
                cnt++;
                prev = p;
            }
        }
        return cnt >= k;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [13,5,1,8,21,2]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1,3,1]\n2\n
// @lcpr case=end

// @lcpr case=start
// [7,7,7,7]\n2\n
// @lcpr case=end

 */

