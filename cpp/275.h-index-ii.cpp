/*
 * @lc app=leetcode.cn id=275 lang=cpp
 * @lcpr version=30103
 *
 * [275] H 指数 II
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
    int hIndex(vector<int> &citations) {
        sort(citations.begin(), citations.end());
        int n = citations.size();
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (citations[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - left;
    }
};
// @lc code=end

/*
// @lcpr case=start
// [0,1,3,5,6]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,100]\n
// @lcpr case=end

 */
