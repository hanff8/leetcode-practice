/*
 * @lc app=leetcode.cn id=1402 lang=cpp
 * @lcpr version=30102
 *
 * [1402] 做菜顺序
 */

// @lcpr-template-start
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
// @lcpr-template-end
// @lc code=start
class Solution {
  public:
    int maxSatisfaction(vector<int> &satisfaction) {
        // return solution1(satisfaction);
        return solution2(satisfaction);
    }
    int solution2(vector<int> &satisfaction) {
        int n = satisfaction.size();
        sort(satisfaction.begin(), satisfaction.end(), greater<int>());
        int res = 0, pre = 0;
        for (int i : satisfaction) {
            if (pre + i > 0) {
                pre += i;
                res += pre;
            }
        }
        return res;
    }
    int solution1(vector<int> &satisfaction) {
        int n = satisfaction.size();
        vector<vector<int>> dp(n + 1, vector<int>(n + 1));
        sort(satisfaction.begin(), satisfaction.end());
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; ++j) {
                dp[i][j] = dp[i - 1][j - 1] + satisfaction[i - 1] * j;
                if (j < i) {
                    dp[i][j] = max(dp[i][j], dp[i - 1][j]);
                }
                res = max(res, dp[i][j]);
            }
        }
        return res;
    }
};
// @lc code=end

/*
// @lcpr case=start
// [-1,-8,0,5,-9]\n
// @lcpr case=end

// @lcpr case=start
// [4,3,2]\n
// @lcpr case=end

// @lcpr case=start
// [-1,-4,-5]\n
// @lcpr case=end

 */
