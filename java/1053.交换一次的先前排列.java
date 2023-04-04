/*
 * @lc app=leetcode.cn id=1053 lang=java
 * 
 * @lcpr version=21901
 *
 * [1053] 交换一次的先前排列
 */

// @lc code=start
class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                int j = n - 1;
                while (arr[j] >= arr[i] || arr[j] == arr[j - 1]) {
                    j--;
                }
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                break;
            }
        }
        return arr;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // [3,2,1]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1,1,5]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1,9,4,6,7]\n // @lcpr case=end
 * 
 */


