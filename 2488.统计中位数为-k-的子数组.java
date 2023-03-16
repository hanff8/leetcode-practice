import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=2488 lang=java
 * 
 * @lcpr version=21801
 *
 * [2488] 统计中位数为 K 的子数组
 */

// @lc code=start
class Solution {
    public int countSubarrays(int[] nums, int k) {
        int pos = 0, n = nums.length;
        while (nums[pos] != k)
            ++pos;

        var cnt = new int[n * 2];
        cnt[n] = 1;
        for (int i = pos - 1, x = n; i >= 0; --i) { // 从 pos-1 开始累加 x
            x += nums[i] < k ? 1 : -1;
            ++cnt[x];
        }

        int ans = cnt[n] + cnt[n - 1];
        for (int i = pos + 1, x = n; i < n; ++i) { // 从 pos+1 开始累加 x
            x += nums[i] > k ? 1 : -1;
            ans += cnt[x] + cnt[x - 1];
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
 * // @lcpr case=start // [3,2,1,4,5]\n4\n // @lcpr case=end
 * 
 * // @lcpr case=start // [2,3,1]\n3\n // @lcpr case=end
 * 
 */


