/*
 * @lc app=leetcode.cn id=1760 lang=cpp
 * @lcpr version=21103
 *
 * [1760] 袋子里最少数目的球
 */
#include <algorithm>
#include <array>
#include <bitset>
#include <climits>
#include <deque>
#include <functional>
#include <iostream>
#include <list>
#include <queue>
#include <stack>
#include <tuple>
#include <unordered_map>
#include <unordered_set>
#include <utility>
#include <vector>
using namespace std;
// @lc code=start
#include <algorithm>
class Solution {
  public:
    int minimumSize(vector<int> &nums, int maxOperations) {
        int left = 1, right = *max_element(nums.begin(), nums.end());
        int ans = 0;

        while (left <= right) {
            int y = (left + right) / 2;
            long long ops = 0;
            for (int n : nums) {
                // 从n到y所需要的操作次数
                ops += (n - 1) / y;
            }
            if (ops <= maxOperations) {
                ans = y;
                right = y - 1;
            } else {
                left = y + 1;
            }
        }
        return ans;
    }
};
// @lc code=end

/*
// @lcpr case=start
// [9]\n2\n
// @lcpr case=end

// @lcpr case=start
// [2,4,8,2]\n4\n
// @lcpr case=end

// @lcpr case=start
// [7,17]\n2\n
// @lcpr case=end

 */
