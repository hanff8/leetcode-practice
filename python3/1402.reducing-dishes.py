#
# @lc app=leetcode.cn id=1402 lang=python3
# @lcpr version=30102
#
# [1402] 做菜顺序
#


# @lcpr-template-start

# @lcpr-template-end
# @lc code=start
class Solution:
    def maxSatisfaction(self, satisfaction: List[int]) -> int:
        # return self.solution1(satisfaction)
        return self.solution2(satisfaction)
    def solution2(self,satisfaction: List[int])->int:
        n = len(satisfaction)
        satisfaction.sort(key=lambda x:-x)
        pre,ans = 0,0
        for i in satisfaction:
            if i+pre>0:
                pre+=i
                ans+=pre
            else:
                break
        return ans



    def solution1(self,satisfaction: List[int])->int:
        n = len(satisfaction)
        dp = [[0 for _ in range(n+1)] for _ in range(n+1)]
        satisfaction.sort()
        ans = 0
        for i in range(1,n+1):
            for j in range(1,i+1):
                dp[i][j] = dp[i-1][j-1]+satisfaction[i-1]*j
                if j<i:
                    dp[i][j] = max(dp[i][j],dp[i-1][j])
                ans = max(ans,dp[i][j])        
        return ans
# @lc code=end



#
# @lcpr case=start
# [-1,-8,0,5,-9]\n
# @lcpr case=end

# @lcpr case=start
# [4,3,2]\n
# @lcpr case=end

# @lcpr case=start
# [-1,-4,-5]\n
# @lcpr case=end

#

