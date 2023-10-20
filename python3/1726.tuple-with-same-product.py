#
# @lc app=leetcode.cn id=1726 lang=python3
# @lcpr version=30102
#
# [1726] 同积元组
#


# @lcpr-template-start

# @lcpr-template-end
# @lc code=start
from collections import Counter


class Solution:
    def tupleSameProduct(self, nums: List[int]) -> int:
        n = len(nums)
        cnt = Counter(nums[i]*nums[j] for i in range(n) for j in range(i+1,n))
        ans =0
        for _,v in cnt.items():
            ans+=v*(v-1)*4
        return ans


# @lc code=end



#
# @lcpr case=start
# [2,3,4,6]\n
# @lcpr case=end

# @lcpr case=start
# [1,2,4,5,10]\n
# @lcpr case=end

#

