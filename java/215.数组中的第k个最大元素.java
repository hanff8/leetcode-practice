import java.util.Arrays;
import java.util.Random;

/*
 * @lc app=leetcode.cn id=215 lang=java
 * 
 * @lcpr version=21901
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; j++) {
            if (a[j] < x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
// @lc code=end

/*
 * // @lcpr case=start // 2\n // @lcpr case=end
 * 
 * // @lcpr case=start // 4\n // @lcpr case=end
 * 
 */
