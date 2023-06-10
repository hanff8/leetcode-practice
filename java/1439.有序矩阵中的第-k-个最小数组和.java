/*
 * @lc app=leetcode.cn id=1439 lang=java
 * 
 * @lcpr version=21908
 *
 * [1439] 有序矩阵中的第 k 个最小数组和
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
import java.util.ArrayDeque;

// @lc code=start
class Solution {
    // public int kthSmallest(int[][] mat, int k) {
    //     var a = new int[] {0};
    //     for (var row : mat) {
    //         var b = new int[a.length * row.length];
    //         int i = 0;
    //         for (int x : a)
    //             for (int y : row)
    //                 // 顺便求和
    //                 b[i++] = x + y;
    //         Arrays.sort(b);
    //         if (b.length > k) // 保留最小的 k 个
    //             b = Arrays.copyOfRange(b, 0, k);
    //         a = b;
    //     }
    //     return a[k - 1];
    // }
    // public int kthSmallest(int[][] mat, int k) {
    //     var a = new int[] {0};
    //     for (var row : mat) {
    //         a = kSmallestPairs(row, a, k);
    //     }
    //     return a[k - 1];
    // }

    // private int[] kSmallestPairs(int[] nums1, int[] nums2, int k) {
    //     int n = nums1.length, m = nums2.length, sz = 0;
    //     var ans = new int[Math.min(k, n * m)];
    //     var pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
    //     pq.add(new int[] {nums1[0] + nums2[0], 0, 0});
    //     while (!pq.isEmpty() && sz < k) {
    //         var p = pq.poll();
    //         int i = p[1], j = p[2];
    //         ans[sz++] = nums1[i] + nums2[j];
    //         if (j == 0 && i + 1 < n) {
    //             pq.add(new int[] {nums1[i + 1] + nums2[0], i + 1, 0});
    //         }
    //         if (j + 1 < m) {
    //             pq.add(new int[] {nums1[i] + nums2[j + 1], i, j + 1});
    //         }
    //     }
    //     return ans;
    // }
    private int leftK;

    public int kthSmallest(int[][] mat, int k) {
        int sl = 0, sr = 0;
        for (var row : mat) {
            sl += row[0];
            sr += row[row.length - 1];
        }

        //二分
        int left = sl - 1, right = sr; //闭区间
        while (left + 1 < right) {
            int mid = (right + left) >>> 1;
            leftK = k;
            if (dfs(mat, mat.length - 1, mid - sl))
                right = mid;
            else {
                left = mid;
            }
        }
        return right;
    }

    private boolean dfs(int[][] mat, int i, int s) {
        if (i < 0) {
            return --leftK == 0;
        }
        for (int x : mat[i]) {
            if (x - mat[i][0] > s) { //剪枝
                break;
            }
            if (dfs(mat, i - 1, s - (x - mat[i][0]))) {
                return true;
            }
        }
        return false;
    }

}
// @lc code=end



/*
// @lcpr case=start
// [[1,3,11],[2,4,6]]\n5\n
// @lcpr case=end

// @lcpr case=start
// [[1,3,11],[2,4,6]]\n9\n
// @lcpr case=end

// @lcpr case=start
// [[1,10,10],[1,4,5],[2,3,6]]\n7\n
// @lcpr case=end

// @lcpr case=start
// [[1,1,10],[2,2,9]]\n7\n
// @lcpr case=end

 */

