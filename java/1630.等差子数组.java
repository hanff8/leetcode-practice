import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1630 lang=java
 * 
 * @lcpr version=21801
 *
 * [1630] 等差子数组
 */

// @lc code=start
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = l.length;
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            int[] tmp = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(tmp);
            // System.out.println(Arrays.toString(tmp));
            int gap = tmp[1] - tmp[0];
            for (int j = 2; j < tmp.length; j++) {
                if (tmp[j] - tmp[j - 1] != gap) {
                    list.add(false);
                    flag = true;
                    break;
                }
            }
            if (!flag)
                list.add(true);
        }
        return list;
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // [4,6,5,9,3,7]\n[0,0,2]\n[2,3,5]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10]\n[0,1,6,4,8,7]\n[4,4,9,7,9,10]\n
 * // @lcpr case=end
 * 
 */


