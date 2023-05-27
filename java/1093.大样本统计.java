/*
 * @lc app=leetcode.cn id=1093 lang=java
 * 
 * @lcpr version=21908
 *
 * [1093] 大样本统计
 */

// @lc code=start

class Solution {
    public double[] sampleStats(int[] count) {
        double[] res = new double[5];
        double min = 0, max = 0, maxShow = 0, maxShowFreq = 0;
        int num = 0;
        long sum = 0;
        int i = 0;
        boolean flag = false, found = false;
        for (; i < count.length; i++) {
            if (count[i] != 0) {
                if (!flag) {
                    min = i;
                    flag = true;
                }
                if (count[i] > maxShowFreq) {
                    maxShowFreq = count[i];
                    maxShow = i;
                }
                sum += i * (long) count[i];
                num += count[i];
                max = i;
            }
        }
        res[0] = min;
        res[1] = max;
        res[2] = (double) sum / num;
        int pivotl = (int) num / 2;
        for (int j = 0; j < count.length; j++) {
            if (count[j] != 0) {
                if (found) {
                    res[3] = (res[3] + j) / 2.0;
                    break;
                }
                pivotl -= count[j];
                if (num % 2 == 0) {
                    if (pivotl == 0) {
                        found = true;
                        res[3] = j;
                        continue;
                    }
                    if (pivotl < 0) {
                        res[3] = j;
                        break;
                    }
                }
                if (num % 2 != 0) {
                    if (pivotl < 0) {
                        res[3] = j;
                        break;
                    }

                }
            }
        }

        res[4] = maxShow;
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]\n
// @lcpr case=end

// @lcpr case=start
// [0,4,3,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]\n
// @lcpr case=end

 */

