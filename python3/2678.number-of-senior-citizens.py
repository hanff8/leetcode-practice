#
# @lc app=leetcode.cn id=2678 lang=python3
# @lcpr version=30102
#
# [2678] 老人的数目
#


# @lcpr-template-start

# @lcpr-template-end
# @lc code=start
class Solution:
    def countSeniors(self, details: List[str]) -> int:
        
        # ages = [int(de[-4:-2]) for de in details]
        # cnt = 0
        # for a in ages:
        #     if a>60:
        #         cnt+=1
        # return cnt
        return sum(1 for info in details if int(info[-4:-2])>60)
# @lc code=end



#
# @lcpr case=start
# ["7868190130M7522","5303914400F9211","9273338290F4010"]\n
# @lcpr case=end

# @lcpr case=start
# ["1313579440F2036","2921522980M5644"]\n
# @lcpr case=end

#

