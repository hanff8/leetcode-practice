/*
 * @lc app=leetcode.cn id=1753 lang=cpp
 * @lcpr version=21103
 *
 * [1753] 移除石子的最大得分
 */
#include <algorithm>
#include <array>
#include <bitset>
#include <climits>
#include <deque>
#include <functional>
#include <iostream>
#include <limits.h>
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
    int maximumScore(int a, int b, int c) {
        // int max = 0, min = 0, medium = 0;
        vector<int> arr = {a, b, c};
        sort(arr.begin(), arr.end());
        if (arr[0] + arr[1] <= arr[2]) {
            return arr[0] + arr[1];
        }
        // sort(arr1.begin(), arr1.end());
        return maximumScore(arr[0] - 1, arr[1] - 1, arr[2]) + 1;
    }
};
// @lc code=end

/*
// @lcpr case=start
// 2\n4\n6\n
// @lcpr case=end

// @lcpr case=start
// 4\n4\n6\n
// @lcpr case=end

// @lcpr case=start
// 1\n8\n8\n
// @lcpr case=end

 */
