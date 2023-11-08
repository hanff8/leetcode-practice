// @lcpr-before-debug-begin

// @lcpr-before-debug-end

/*
 * @lc app=leetcode.cn id=274 lang=cpp
 * @lcpr version=30103
 *
 * [274] H 指数
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
    int solution1(vector<int> &citations) {
        sort(citations.begin(), citations.end());
        int h = 0, i = citations.size() - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }
    int solution2(vector<int> &citations) {
        sort(citations.begin(), citations.end());
        int left = 0, right = citations.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 0; i < citations.size(); i++) {
                if (citations[i] >= mid) {
                    cnt++;
                }
            }
            if (cnt > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    int hIndex(vector<int> &citations) { return solution1(citations); }
};
//
// 0 1 3 5 6
// @lc code=end

/*
// @lcpr case=start
// [3,0,6,1,5]\n
// @lcpr case=end

// @lcpr case=start
// [1,3,1]\n
// @lcpr case=end

 */
