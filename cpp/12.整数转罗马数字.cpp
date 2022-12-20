/*
 * @lc app=leetcode.cn id=12 lang=cpp
 * @lcpr version=21007
 *
 * [12] 整数转罗马数字
 */
// #include <algorithm>
// #include <array>
// #include <bitset>
// #include <climits>
// #include <deque>
// #include <functional>
// #include <iostream>
// #include <list>
// #include <queue>
// #include <stack>
// #include <tuple>
// #include <unordered_map>
// #include <unordered_set>
// #include <utility>
// #include <vector>
// using namespace st#include <algorithm>
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
  string intToRoman(int num) {

    string result;
    string symbol[] = {"I",  "IV", "V",  "IX", "X",  "XL", "L",
                       "XC", "C",  "CD", "D",  "CM", "M"};
    int value[] = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

    for (int i = 0; i < 13; ++i) {
      while (num >= value[12 - i]) {
        
          num -= value[12 - i];
          result += symbol[12 - i];
      }
    }
    return result;
  }
};
// @lc code=end

/*
// @lcpr case=start
// 3\n
// @lcpr case=end

// @lcpr case=start
// 4\n
// @lcpr case=end

// @lcpr case=start
// 9\n
// @lcpr case=end

// @lcpr case=start
// 58\n
// @lcpr case=end

// @lcpr case=start
// 1994\n
// @lcpr case=end

 */
