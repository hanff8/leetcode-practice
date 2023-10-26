#
# @lc app=leetcode.cn id=1465 lang=python3
# @lcpr version=30102
#
# [1465] 切割后面积最大的蛋糕
#


# @lcpr-template-start

# @lcpr-template-end
# @lc code=start
class Solution:
    def maxArea(self, h: int, w: int, horizontalCuts: List[int], verticalCuts: List[int]) -> int:
        def calMax(arr:list[int],border:int):
            res,pre=0,0
            for i in range(0,len(arr)):
                res = max(res,arr[i]-pre)
                pre = arr[i]
            return max(res,border-pre)
        verticalCuts.sort()
        horizontalCuts.sort()
        return calMax(horizontalCuts,h)*calMax(verticalCuts,w)%1000000007
# @lc code=end



#
# @lcpr case=start
# 5\n4\n[1,2,4]\n[1,3]\n
# @lcpr case=end

# @lcpr case=start
# 5\n4\n[3,1]\n[1]\n
# @lcpr case=end

# @lcpr case=start
# 5\n4\n[3]\n[3]\n
# @lcpr case=end

#

