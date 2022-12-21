/*
 * @lc app=leetcode.cn id=438 lang=cpp
 * @lcpr version=21104
 *
 * [438] 找到字符串中所有字母异位词
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
    vector<int> findAnagrams(string s, string p) {
        vector<int> res;
        vector<int> arr(26);
        for (int i = 0; i < p.size(); ++i) {
            ++arr[p[i] - 'a'];
        }

        for (int l = 0, r = 0; r < s.size(); ++r) {

            --arr[s[r] - 'a'];
            //  不进while循环则表示字符匹配成功
            while (arr[s[r] - 'a'] < 0) {
                //字符匹配失败，还原arr表，同时左窗口右移
                ++arr[s[l] - 'a'];
                ++l;
            }
            if (r - l + 1 == p.size())
                res.push_back(l);
        }
        return res;
    }
};
// @lc code=end

/*
// @lcpr case=start
// "cbaebabacd"\n"abc"\n
// @lcpr case=end

// @lcpr case=start
// "abab"\n"ab"\n
// @lcpr case=end

 */
