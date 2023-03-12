import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1590 lang=java
 * 
 * @lcpr version=21801
 *
 * [1590] 使数组和能被 P 整除
 */

// @lc code=start
class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length, ans = n;
        var s = new int[n + 1];
        for (int i = 0; i < n; ++i)
            s[i + 1] = (s[i] + nums[i]) % p;
        int x = s[n];
        if (x == 0)
            return 0; // 移除空子数组（这行可以不要）

        var last = new HashMap<Integer, Integer>();
        for (int i = 0; i <= n; ++i) {
            last.put(s[i], i);
            // 如果不存在，-n 可以保证 i-j >= n
            int j = last.getOrDefault((s[i] - x + p) % p, -n);
            ans = Math.min(ans, i - j);
        }
        return ans < n ? ans : -1;
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // [3,1,4,2]\n6\n // @lcpr case=end
 * 
 * // @lcpr case=start // [6,3,5,2]\n9\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1,2,3]\n3\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1,2,3]\n7\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1000000000,1000000000,1000000000]\n3\n // @lcpr case=end
 * 
 */


