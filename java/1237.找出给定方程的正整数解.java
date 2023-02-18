import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1237 lang=java
 * @lcpr version=21704
 *
 * [1237] 找出给定方程的正整数解
 */

// @lc code=start
/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        var res = new ArrayList<List<Integer>>();
        for (int x = 1; x <= 1000; ++x) {
            int left = 1, right = 1000;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (customfunction.f(x, mid) == z) {
                    res.add(new ArrayList<>(List.of(x, mid)));
                }
                if (customfunction.f(x, mid) > z) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return res;
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
 * // 1\n5\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 2\n5\n
 * // @lcpr case=end
 * 
 */
