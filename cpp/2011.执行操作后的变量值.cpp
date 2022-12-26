/*
 * @lc app=leetcode.cn id=2011 lang=cpp
 * @lcpr version=21104
 *
 * [2011] 执行操作后的变量值
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
    int finalValueAfterOperations(vector<string> &operations) {
        unordered_map<string, int> array;
        array.emplace("--X", -1);
        array.emplace("X--", -1);
        array.emplace("++X", 1);
        array.emplace("X++", 1);
        int res = 0;
        for (string str : operations) {
            cout << array.count(str) << endl;
            res += array.find(str)->second;
        }
        return res;
    }
};
// @lc code=end

/*
// @lcpr case=start
// ["--X","X++","X++"]\n
// @lcpr case=end

// @lcpr case=start
// ["++X","++X","X++"]\n
// @lcpr case=end

// @lcpr case=start
// ["X++","++X","--X","X--"]\n
// @lcpr case=end

 */
