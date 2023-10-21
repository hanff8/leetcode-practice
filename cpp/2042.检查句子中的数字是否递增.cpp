/*
 * @lc app=leetcode.cn id=2042 lang=cpp
 * @lcpr version=21105
 *
 * [2042] 检查句子中的数字是否递增
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
#include <sstream>
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
    bool areNumbersAscending(string s) {
        int pre = -1;
        istringstream is(s);

        for (int i = 0; i < s.size();) {
            if (s[i] >= '0' && s[i] <= '9' && s[i + 1] >= '0' &&
                s[i + 1] <= '9') {
                string temp = s.substr(i, 2);
                int num = (s[i] - '0') * 10 + (s[i + 1] - '0');
                if (num > pre)
                    pre = num;
                else
                    return false;
                i = i + 2;
            } else if (s[i] >= '0' && s[i] <= '9') {
                int num = s[i] - '0';
                if (num > pre)
                    pre = num;
                else
                    return false;
                ++i;
            } else {
                ++i;
            }
        }
        return true;
    }
};
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=areNumbersAscending
// paramTypes= ["string"]
// @lcpr-div-debug-arg-end

/*
// @lcpr case=start
// "1 box has 3 blue 4 red 6 green and 12 yellow marbles"\n
// @lcpr case=end

// @lcpr case=start
// "hello world 5 x 5"\n
// @lcpr case=end

// @lcpr case=start
// "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"\n
// @lcpr case=end

// @lcpr case=start
// "4 5 11 26"\n
// @lcpr case=end

 */
