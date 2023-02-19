import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=1792 lang=java
 * @lcpr version=21704
 *
 * [1792] 最大平均通过率
 */

// @lc code=start
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // 递减
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
            long val1 = (long) (b[1] + 1) * b[1] * (a[1] - a[0]);
            long val2 = (long) (a[1] + 1) * a[1] * (b[1] - b[0]);
            if (val1 == val2) {
                return 0;
            }
            return val1 < val2 ? 1 : -1;
        });

        for (int[] is : classes) {
            pq.offer(new int[] { is[0], is[1] });
        }
        for (int i = 0; i < extraStudents; i++) {
            int arr[] = pq.poll();
            int pass = arr[0], total = arr[1];
            pq.offer(new int[] { pass + 1, total + 1 });
        }
        double res = 0;
        for (int j = 0; j < classes.length; j++) {
            int[] arr = pq.poll();
            int pass = arr[0], total = arr[1];
            res += 1.0 * pass / total;
        }
        return res / classes.length;
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
 * // [[1,2],[3,5],[2,2]]\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[2,4],[3,9],[4,5],[2,10]]\n4\n
 * // @lcpr case=end
 * 
 */
