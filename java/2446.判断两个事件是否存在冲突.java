/*
 * @lc app=leetcode.cn id=2446 lang=java
 * 
 * @lcpr version=21907
 *
 * [2446] 判断两个事件是否存在冲突
 */

// @lc code=start
class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        // if (convert2Second(event2[0]) > convert2Second(event1[1])
        //         || convert2Second(event2[1]) < convert2Second(event1[0]))
        //     return false;
        return !(event2[0].compareTo(event1[1]) > 0 || event2[1].compareTo(event1[0]) < 0);

    }

    private int convert2Second(String time) {
        String[] arr = time.split(":");
        int res = Integer.valueOf(arr[0]) * 60 + Integer.valueOf(arr[1]);
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// ["01:15","02:00"]\n["02:00","03:00"]\n
// @lcpr case=end

// @lcpr case=start
// ["01:00","02:00"]\n["01:20","03:00"]\n
// @lcpr case=end

// @lcpr case=start
// ["10:00","11:00"]\n["14:00","15:00"]\n
// @lcpr case=end

 */

