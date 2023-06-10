/*
 * @lc app=leetcode.cn id=875 lang=java
 * 
 * @lcpr version=21908
 *
 * [875] 爱吃香蕉的珂珂
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    // 搞清楚二分搜索中上下界的区间的开闭关系，正确使用对应的模板
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left = 1, right = piles[piles.length - 1];
        while (left <= right) {
            int mid = (left + right) / 2;
            long time = getTime(piles, mid);
            if (time > h) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private long getTime(int[] piles, int k) {
        long ans = 0;
        for (int i = 0; i < piles.length; i++) {
            //除法向上取整
            int time = (piles[i] + k - 1) / k;
            // System.out.println(time);
            ans += time;
        }
        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,6,7,11]\n8\n
// @lcpr case=end

// @lcpr case=start
// [30,11,23,4,20]\n5\n
// @lcpr case=end

// @lcpr case=start
// [30,11,23,4,20]\n6\n
// @lcpr case=end

 */

