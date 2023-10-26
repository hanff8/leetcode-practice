# @lcpr-before-debug-begin
from python3problem2698 import *
from typing import *

# @lcpr-before-debug-end

#
# @lc app=leetcode.cn id=2698 lang=python3
# @lcpr version=30102
#
# [2698] 求一个整数的惩罚数
#


# @lcpr-template-start


# @lcpr-template-end
# @lc code=start
class Solution:
    def punishmentNumber(self, n: int) -> int:
        res = 0

        def valid(s: str, pos: int, tot: int, origin: int) -> bool:
            if pos == len(s):
                return tot == origin
            sum = 0
            for i in range(pos, len(s)):
                sum = sum * 10 + int(s[i])
                if sum + tot > origin:
                    break
                if valid(s, i + 1, sum + tot, origin):
                    return True
            return False

        for i in range(1, n + 1):
            if valid(str(i * i), 0, 0, i):
                res += i * i
        return res


# @lc code=end


# @lcpr-div-debug-arg-start
# funName=punishmentNumber
# paramTypes= ["number"]
# @lcpr-div-debug-arg-end


#
# @lcpr case=start
# 10\n
# @lcpr case=end

# @lcpr case=start
# 37\n
# @lcpr case=end

#
