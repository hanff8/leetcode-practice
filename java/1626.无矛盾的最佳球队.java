import java.util.Arrays;
import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

/*
 * @lc app=leetcode.cn id=1626 lang=java
 * 
 * @lcpr version=21801
 *
 * [1626] 无矛盾的最佳球队
 */

// @lc code=start
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        int[][] people = new int[n][2];
        for (int i = 0; i < people.length; i++) {
            people[i] = new int[] {scores[i], ages[i]};
        }
        Arrays.sort(people, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (people[j][1] <= people[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += people[i][0];
            ans = Math.max(ans, dp[i]);
        }
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
 * // @lcpr case=start // [1,3,5,10,15]\n[1,2,3,4,5]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [4,5,6,5]\n[2,1,2,1]\n // @lcpr case=end
 * 
 * // @lcpr case=start // [1,2,3,5]\n[8,9,10,1]\n // @lcpr case=end
 * 
 */


