/*
 * @lc app=leetcode.cn id=LCP 33 lang=java
 * 
 * @lcpr version=21908
 *
 * [LCP 33] 蓄水
 */

// @lc code=start
class Solution {
    public int storeWater(int[] bucket, int[] vat) {
        int n = bucket.length;
        int maxk = Arrays.stream(vat).max().getAsInt();
        if (maxk == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int k = 1; k <= maxk && k < res; ++k) {
            int t = 0;
            for (int i = 0; i < bucket.length; ++i) {
                t += Math.max(0, (vat[i] + k - 1) / k - bucket[i]);
            }
            res = Math.min(res, t + k);
        }
        return res;
    }
}

// @lc code=end



/*
// @lcpr case=start
// [1,3]\n[6,8]`>\n
// @lcpr case=end

// @lcpr case=start
// [9,0,1]\n[0,2,2]`>\n
// @lcpr case=end

 */

