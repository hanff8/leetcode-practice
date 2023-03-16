import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=面试题 17.05 lang=java
 * 
 * @lcpr version=21801
 *
 * [面试题 17.05] 字母与数字
 */

// @lc code=start
class Solution {

    public String[] findLongestSubarray(String[] array) {
        int n = array.length;
        // int[] prefixSum = new int[n + 1];
        int prefixSum = 0;
        int maxLength = 0;
        int startIndex = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            if (Character.isLetter(array[i].charAt(0)))
                prefixSum++;
            else
                prefixSum--;
            if (map.containsKey(prefixSum)) {
                int firstIndex = map.get(prefixSum);
                if (i - firstIndex > maxLength) {
                    maxLength = i - firstIndex;
                    startIndex = firstIndex + 1;
                }
            } else {
                map.put(prefixSum, i);
            }
        }
        var ans = new String[maxLength];
        System.arraycopy(array, startIndex, ans, 0, maxLength);
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
 * // @lcpr case=start // // @lcpr case=end
 * 
 * // @lcpr case=start // // @lcpr case=end
 * 
 */


