/*
 * @lc app=leetcode.cn id=1054 lang=java
 * 
 * @lcpr version=21907
 *
 * [1054] 距离相等的条形码
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;

// @lc code=start
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        return func2(barcodes);
    }

    public int[] func1(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (var i : barcodes) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[] {entry.getValue(), entry.getKey()});
        }
        int n = barcodes.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int[] p = pq.poll();
            if (i == 0 || res[i - 1] != p[1]) {
                res[i] = p[1];
                if (p[0] > 1) {
                    pq.offer(new int[] {p[0] - 1, p[1]});
                }
            } else {
                int[] p2 = pq.poll();
                res[i] = p2[1];
                if (p2[0] > 1) {
                    pq.offer(new int[] {p2[0] - 1, p2[1]});
                }
                pq.offer(new int[] {p[0], p[1]});
            }
        }
        return res;
    }

    public int[] func2(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        // int max = 0;
        for (var i : barcodes) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            // max = Math.max(max, map.get(i));
        }
        int evenIndex = 0, oddIndex = 1;
        int n = barcodes.length;
        int halfLength = n / 2;
        int[] res = new int[n];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            while (val > 0 && val <= halfLength && oddIndex < n) {
                res[oddIndex] = key;
                val--;
                oddIndex += 2;
            }
            while (val > 0) {
                res[evenIndex] = key;
                val--;
                evenIndex += 2;
            }
        }
        return res;
    }


}
// @lc code=end



/*
 * // @lcpr case=start // [1,1,1,2,2,2]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1,1,1,1,2,2,3,3]\n // @lcpr case=end
 * 
 */

