/*
 * @lc app=leetcode.cn id=2032 lang=cpp
 * @lcpr version=21104
 *
 * [2032] 至少在两个数组中出现的值
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
    vector<int> twoOutOfThree(vector<int> &nums1, vector<int> &nums2,
                              vector<int> &nums3) {
        unordered_map<int, int> arr;
        vector<int> res;
        // 1
        for (int val : nums1) {
            arr[val] = 1;
        }

        // 10
        for (int val : nums2) {
            arr[val] |= 2;
        }

        // 100
        for (int val : nums3) {
            arr[val] |= 4;
        }

        for (auto a : arr) {
            if (a.second & (a.second - 1)) {
                res.push_back(a.first);
            }
        }
        return res;
    }
};
// @lc code=end

/*
// @lcpr case=start
// [1,1,3,2]\n[2,3]\n[3]\n
// @lcpr case=end

// @lcpr case=start
// [3,1]\n[2,3]\n[1,2]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,2]\n[4,3,3]\n[5]\n
// @lcpr case=end

 */
