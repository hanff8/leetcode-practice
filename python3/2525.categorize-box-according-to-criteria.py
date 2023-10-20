#
# @lc app=leetcode.cn id=2525 lang=python3
# @lcpr version=30102
#
# [2525] 根据规则将箱子分类
#


# @lcpr-template-start

# @lcpr-template-end
# @lc code=start
class Solution:
    def categorizeBox(self, length: int, width: int, height: int, mass: int) -> str:
        MAX_V=1_000_000_000
        MAX_D=1_0000
        V = length*width*height
        isHeavy = mass>=100
        isBulky = V>=MAX_V or max(width,height,length)>=MAX_D
        if isBulky and isHeavy:
            return "Both"
        elif isBulky:
            return "Bulky"
        elif isHeavy:
            return "Heavy"
        else:
            return "Neither"
        
# @lc code=end



#
# @lcpr case=start
# 1000\n35\n700\n300\n
# @lcpr case=end

# @lcpr case=start
# 200\n50\n800\n50\n
# @lcpr case=end

#

