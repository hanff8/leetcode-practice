import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2383 lang=java
 * 
 * @lcpr version=21801
 *
 * [2383] 赢得比赛需要的最少训练时长
 */

// @lc code=start
class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy,
            int[] experience) {
        int ans = 0;
        for (int i = 0; i < experience.length; i++) {
            if (initialExperience > experience[i]) {
                initialExperience += experience[i];
            } else {
                ans += experience[i] - initialExperience + 1;
                // initialExperience = experience[i] + 1;
                initialExperience = 2 * experience[i] + 1;
            }


            // System.out.println(ans);
        }
        int energySum = Arrays.stream(energy).sum();
        int energyGap = initialEnergy > energySum ? 0 : energySum - initialEnergy + 1;
        return ans + energyGap;
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // 5\n3\n[1,4,3,2]\n[2,6,3,1]\n // @lcpr case=end
 * 
 * // @lcpr case=start // 2\n4\n[1]\n[3]\n // @lcpr case=end
 * 
 */


