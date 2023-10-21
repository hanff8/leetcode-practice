// @lcpr-before-debug-begin




// @lcpr-before-debug-end

/*
 * @lc app=leetcode.cn id=2530 lang=cpp
 * @lcpr version=30102
 *
 * [2530] 执行 K 次操作后的最大分数
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
    long long maxKelements(vector<int> &nums, int k) {
        priority_queue<int> q(nums.begin(), nums.end());
        long long ans = 0;
        for (int i = 0; i < k; i++) {
            int x = q.top();
            q.pop();
            ans += x;
            q.push((x + 2) / 3);
        }
        return ans;
    }
};
// @lc code=end

/*
// @lcpr case=start
// [10,10,10,10,10]\n5\n
// @lcpr case=end

// @lcpr case=start
// [1,10,3,3,3]\n3\n
// @lcpr case=end

 */
