#
# @lc app=leetcode.cn id=1155 lang=python3
# @lcpr version=30102
#
# [1155] 掷骰子等于目标和的方法数
#


# @lcpr-template-start

# @lcpr-template-end
# @lc code=start
class Solution:
    def numRollsToTarget(self, n: int, k: int, target: int) -> int:
        mod = 10**9+7
        @cache
        def dfs(i:int,j:int)->int:
            if i==0:
                return int(j==0)
            res = 0
            for x in range(min(k,j+1)):
                res+=dfs(i-1,j-x)
            return res%mod
        return dfs(n,target-n)
# @lc code=end



#
# @lcpr case=start
# 1\n6\n3\n
# @lcpr case=end

# @lcpr case=start
# 2\n6\n7\n
# @lcpr case=end

# @lcpr case=start
# 30\n30\n500\n
# @lcpr case=end

#

