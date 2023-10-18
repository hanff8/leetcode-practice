#
# @lc app=leetcode.cn id=2530 lang=python3
# @lcpr version=30102
#
# [2530] 执行 K 次操作后的最大分数
#


# @lcpr-template-start

# @lcpr-template-end
# @lc code=start
from heapq import heapify, heappop, heappush
import queue


class Solution:
    def maxKelements(self, nums: List[int], k: int) -> int:
        n = len(nums)
        queue = [-x for x in nums]
        heapify(queue)

        ans = 0
        for _ in range(k):
            x = heappop(queue)
            ans+=-x
            heappush(queue,-((-x+2)//3))
        return ans
# @lc code=end



#
# @lcpr case=start
# [10,10,10,10,10]\n5\n
# @lcpr case=end

# @lcpr case=start
# [1,10,3,3,3]\n3\n
# @lcpr case=end

#

