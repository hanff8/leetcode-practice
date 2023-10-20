/*
 * @lc app=leetcode.cn id=2525 lang=cpp
 * @lcpr version=30102
 *
 * [2525] 根据规则将箱子分类
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
    string categorizeBox(int length, int width, int height, int mass) {
        bool isHeavy = mass >= 100;
        bool isBulky = (long long)length * width * height >= 1000000000 ||
                       max(length, max(width, height)) >= 10000;
        if (isHeavy && isBulky) {
            return "Both";
        } else if (isHeavy) {
            return "Heavy";
        } else if (isBulky) {
            return "Bulky";
        } else
            return "Neither";
    }
};
// @lc code=end

/*
// @lcpr case=start
// 1000\n35\n700\n300\n
// @lcpr case=end

// @lcpr case=start
// 200\n50\n800\n50\n
// @lcpr case=end

 */
