/*
 * @lc app=leetcode.cn id=1465 lang=cpp
 * @lcpr version=30102
 *
 * [1465] 切割后面积最大的蛋糕
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
    int maxArea(int h, int w, vector<int> &horizontalCuts,
                vector<int> &verticalCuts) {
        sort(verticalCuts.begin(), verticalCuts.end());
        sort(horizontalCuts.begin(), horizontalCuts.end());
        return (int)calMax(horizontalCuts, h) * calMax(verticalCuts, w) %
               1000000007;
    }
    long long calMax(vector<int> arr, int boarder) {
        int res = 0, pre = 0;
        for (int i = 0; i < arr.size(); i++) {
            res = max(res, arr[i] - pre);
            pre = arr[i];
        }
        return max(res, boarder - pre);
    }
};
// @lc code=end

/*
// @lcpr case=start
// 5\n4\n[1,2,4]\n[1,3]\n
// @lcpr case=end

// @lcpr case=start
// 5\n4\n[3,1]\n[1]\n
// @lcpr case=end

// @lcpr case=start
// 5\n4\n[3]\n[3]\n
// @lcpr case=end

 */
