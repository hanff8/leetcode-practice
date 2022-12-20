/*
 * @lc app=leetcode.cn id=1785 lang=cpp
 * @lcpr version=21102
 *
 * [1785] 构成特定和需要添加的最少元素
 */
#include <algorithm>
#include <array>
#include <bitset>
#include <climits>
#include <cmath>
#include <cstdlib>
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
    int minElements(vector<int>& nums, int limit, int goal) {
        long long sum=0;
        for (auto i : nums) {
            sum+=i;
        }
        long long diff = abs(sum - goal);
        return (diff + limit - 1) / limit;
    }
};
// @lc code=end



/*
// @lcpr case=start
// [1,-1,1]\n3\n-4\n
// @lcpr case=end

// @lcpr case=start
// [1,-10,9,1]\n100\n0\n
// @lcpr case=end

 */


