/*
 * @lc app=leetcode.cn id=1799 lang=cpp
 * @lcpr version=21104
 *
 * [1799] N 次操作后的最大分数和
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
class Solution {
  public:
    int maxScore(vector<int> &nums) {
        int gcd[15][15];
        int n = nums.size();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                gcd[i][j] = __gcd(nums[i], nums[j]);
            }
        }
        // gcd 下三角不包括对角线的矩阵
        vector<int> dp(1 << n, 0);

        function<int(int, int)> dfs = [&](int state, int cnt) {
            if (dp[state] != 0)
                return dp[state];
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {

                    // 跳过已经走过的
                    if (((state >> i) & 1) == 0 or ((state >> j) & 1) == 0)
                        continue;
                    //
                    int cur_state = state ^ (1 << i) ^ (1 << j);
                    dp[state] = max(dp[state],
                                    dfs(cur_state, cnt + 1) + cnt * gcd[i][j]);
                }
            }
            return dp[state];
        };
        return dfs((1 << n) - 1, 1);
    }
};
// @lc code=end

/*
// @lcpr case=start
// [1,2]\n
// @lcpr case=end

// @lcpr case=start
// [3,4,6,8]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,5,6]\n
// @lcpr case=end

 */
