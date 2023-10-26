/*
 * @lc app=leetcode.cn id=1155 lang=cpp
 * @lcpr version=30102
 *
 * [1155] 掷骰子等于目标和的方法数
 */

// @lcpr-template-start
#include <algorithm>
#include <array>
#include <bitset>
#include <climits>
#include <cstring>
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
    int numRollsToTarget(int n, int k, int target) {
        static int MOD = 1000000007;
        vector<vector<int>> memo(n + 1, vector<int>(target - n + 1, -1));
        function<int(int, int)> dfs = [&](int i, int j) -> int {
            if (i == 0)
                return j == 0 ? 1 : 0;
            if (memo[i][j] != -1)
                return memo[i][j];
            int res = 0;
            for (int x = 0; x < k && x <= j; x++) {
                res = ((res + dfs(i - 1, j - x)) % MOD);
            }
            return memo[i][j] = res;
        };
        return dfs(n, target - n);
    }
};
// @lc code=end

/*
// @lcpr case=start
// 1\n6\n3\n
// @lcpr case=end

// @lcpr case=start
// 2\n6\n7\n
// @lcpr case=end

// @lcpr case=start
// 30\n30\n500\n
// @lcpr case=end

 */
