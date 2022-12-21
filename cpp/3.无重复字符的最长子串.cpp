/*
 * @lc app=leetcode.cn id=3 lang=cpp
 * @lcpr version=21007
 *
 * [3] 无重复字符的最长子串
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
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> arr;
        int n = s.size();
        int left = -1, maxlength = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                arr.erase(s[i - 1]);
            }
            while (left + 1 < n && !arr.count(s[left + 1])) {
                arr.insert(s[left + 1]);
                ++left;
            }
            maxlength = max(maxlength, left - i + 1);
        }
        return maxlength;
    }
};
// @lc code=end

/*
// @lcpr case=start
// "abcabcbb"\n
// @lcpr case=end

// @lcpr case=start
// "bbbbb"\n
// @lcpr case=end

// @lcpr case=start
// "pwwkew"\n
// @lcpr case=end

 */
