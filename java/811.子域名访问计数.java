/*
 * @lc app=leetcode.cn id=811 lang=java
 * 
 * @lcpr version=21907
 *
 * [811] 子域名访问计数
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
// @lc code=start

import java.util.HashMap;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        int n = cpdomains.length;
        for (int i = 0; i < n; ++i) {
            String[] arr = cpdomains[i].split(" ");
            int count = Integer.valueOf(arr[0]);
            String[] arr1 = arr[1].split("\\.");
            StringBuilder sb = new StringBuilder();
            for (int j = arr1.length - 1; j >= 0; j--) {
                if (j != arr1.length - 1)
                    sb.insert(0, '.');
                sb.insert(0, arr1[j]);
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + count);
            }
        }
        List<String> res = new ArrayList<>();
        for (var val : map.entrySet()) {
            res.add(val.getValue() + " " + val.getKey());
        }
        return res;
    }
}
// @lc code=end



/*
 * // @lcpr case=start // ["9001 discuss.leetcode.com"]\n // @lcpr case=end
 * 
 * // @lcpr case=start // ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com",
 * "5 wiki.org"]\n // @lcpr case=end
 * 
 */

