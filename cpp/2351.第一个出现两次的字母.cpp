/*
 * @lc app=leetcode.cn id=2351 lang=cpp
 * @lcpr version=21104
 *
 * [2351] 第一个出现两次的字母
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
    char repeatedCharacter(string s) {
        // unordered_set<char> arr;
        // for (char c : s) {
        //     if(arr.count(c)){
        //         return c;
        //     }
        //     arr.insert(c);
        // }
        // return 0;

        int seen=0;
        for (char c: s) {
            int x = c-'a';
            if(seen&(1<<x)){
                return c;
            }
            seen |= 1<<x;
        }
        return ' ';
    }
};
// @lc code=end



/*
// @lcpr case=start
// "abccbaacz"\n
// @lcpr case=end

// @lcpr case=start
// "abcdd"\n
// @lcpr case=end

 */


