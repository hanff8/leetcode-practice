/*
 * @lc app=leetcode.cn id=42 lang=java
 * 
 * @lcpr version=21908
 *
 * [42] 接雨水
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Deque;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.IntStream;

// @lc code=start
class Solution {

    public int trap(int[] height) {
        // return solution1(height);
        // return solution2(height);
        // return solution3(height);
        // return solution4(height);
        return solution5(height);
    }

    //方法一，按层遍历 ，超时, 复杂度m*n m是层数 
    public int solution1(int[] height) {
        int n = height.length;
        int max = Arrays.stream(height).max().getAsInt();
        int ans = 0;
        for (int i = 1; i <= max; i++) {
            boolean flag = false;
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                if (flag && height[j] < i) {
                    tmp++;
                }
                if (height[j] >= i) {
                    ans += tmp;
                    tmp = 0;
                    flag = true;
                }
            }
        }
        return ans;
    }

    //方法二,按列遍历，用streamAPI会超时，循环不会 n^2
    public int solution2(int[] height) {
        int sum = 0, n = height.length;
        // 最左最右两边的墙壁不用考虑，因为不会有水
        for (int i = 1; i < n - 1; i++) {
            //左边最高
            // 超时
            // int leH = Arrays.stream(Arrays.copyOfRange(height, 0, i)).max().getAsInt();
            // 不会超时
            int leH = 0;
            for (int j = i - 1; j >= 0; j--) {
                leH = Math.max(leH, height[j]);
            }
            //超时
            // int leH = IntStream.rangeClosed(0, i - 1).map(e -> height[e]).max().getAsInt();

            //右边最高
            // int rgH = Arrays.stream(Arrays.copyOfRange(height, i, n)).max().getAsInt();
            int rgH = 0;
            for (int j = i; j < n; j++) {
                rgH = Math.max(rgH, height[j]);
            }
            //超时
            // int rgH = IntStream.rangeClosed(i, n - 1).map(e -> height[e]).max().getAsInt();
            int min = Math.min(leH, rgH);
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }
        return sum;
    }

    //方法三,动态规划，基于方法二，使用动态规划来存储每一个点的左右墙的最大高度 复杂度 n
    public int solution3(int[] height) {
        int n = height.length;
        int sum = 0;
        // max_left[i]表示i左边的最高的墙
        int[] max_left = new int[n];
        // max_right[i]表示i右边的最高的墙
        int[] max_right = new int[n];
        for (int i = 1; i < n; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
            max_right[n - i - 1] = Math.max(max_right[n - i], height[n - i]);
        }
        for (int i = 1; i < n; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i])
                sum += (min - height[i]);
        }

        return sum;
    }

    // 因为动态规划的数组只用到一次，因此将动态规划的数组优化成一个单一变量， 复杂度 n
    public int solution4(int[] height) {
        int n = height.length;
        int sum = 0, left = 1, right = n - 2;
        int max_left = 0, max_right = 0;
        for (int i = 1; i < n - 1; i++) {
            //当left指针在right左边
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if (min > height[left]) {
                    sum += (min - height[left]);
                }
                left++;
                // 右边
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    sum += (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }

    //单调栈
    public int solution5(int[] height) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = height.length;
        int sum = 0;
        int i = 0;
        while (i < n) {
            while (!deque.isEmpty() && height[i] > height[deque.peek()]) {
                int h = height[deque.peek()];
                deque.pop();
                if (deque.isEmpty()) {
                    break;
                }
                int distance = i - deque.peek() - 1;
                int min = Math.min(height[i], height[deque.peek()]);
                sum += distance * (min - h);
            }
            deque.push(i);
            i++;
        }
        return sum;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [0,1,0,2,1,0,1,3,2,1,2,1]\n
// @lcpr case=end

// @lcpr case=start
// [4,2,0,3,2,5]\n
// @lcpr case=end

 */

