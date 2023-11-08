/*
 * @lc app=leetcode.cn id=2558 lang=cpp
 * @lcpr version=30102
 *
 * [2558] 从数量最多的堆取走礼物
 */

// @lcpr-template-start
#include <algorithm>
#include <array>
#include <bitset>
#include <climits>
#include <cmath>
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
    long long pickGifts(vector<int> &gifts, int k) {
        priority_queue<int> pq(gifts.begin(), gifts.end());
        while (k--) {
            int x = pq.top();
            pq.pop();
            pq.push(int(sqrt(x)));
        }
        long long res = 0;
        while (pq.size()) {
            res += pq.top();
            pq.pop();
        }
        return res;
    }
};
// @lc code=end

/*
// @lcpr case=start
// [25,64,9,4,100]\n4\n
// @lcpr case=end

// @lcpr case=start
// [1,1,1,1]\n4\n
// @lcpr case=end

 */
