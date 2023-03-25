import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1574 lang=java
 * 
 * @lcpr version=21801
 *
 * [1574] 删除最短的子数组使剩余数组有序
 */

// @lc code=start
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        // 枚举左端点
        // int n = arr.length, right = n - 1;
        // while (right > 0 && arr[right - 1] <= arr[right])
        // --right;
        // if (right == 0)
        // return 0; // arr 已经是非递减数组
        // // 此时 arr[right-1] > arr[right]
        // int ans = right; // 删除 0 到 right-1
        // for (int left = 0; left == 0 || arr[left - 1] <= arr[left]; ++left) {
        // while (right < n && arr[right] < arr[left])
        // ++right;
        // // 此时 arr[left] <= arr[right]，从 left+1 到 right-1 可以删除
        // ans = Math.min(ans, right - left - 1);
        // }
        // return ans;
        // 枚举右端点
        int n = arr.length, right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right])
            right--;
        if (right == 0)
            return 0;
        int ans = right;
        for (int left = 0;; ++right)
            while (right == n || arr[left] <= arr[right]) {
                ans = Math.min(ans, right - left - 1);
                if (arr[left] > arr[left + 1]) {
                    return ans;
                }
                ++left;
            }
    }

}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // [1,2,3,10,4,2,3,5]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [5,4,3,2,1]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1,2,3]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1]\n // @lcpr case=end
 * 
 */


