#
# @lc app=leetcode.cn id=2520 lang=python3
# @lcpr version=30102
#
# [2520] 统计能整除数字的位数
#


# @lcpr-template-start

# @lcpr-template-end
# @lc code=start
class Solution:
    def countDigits(self, num: int) -> int:
        t=  num
        res = 0
        while t!=0:
            if num%(t%10)==0:
                res+=1
            t//=10
        return res
        
# @lc code=end



#
# @lcpr case=start
# 7\n
# @lcpr case=end

# @lcpr case=start
# 121\n
# @lcpr case=end

# @lcpr case=start
# 1248\n
# @lcpr case=end

#

