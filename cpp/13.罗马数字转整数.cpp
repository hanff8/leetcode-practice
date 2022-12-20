/*
 * @lc app=leetcode.cn id=13 lang=cpp
 * @lcpr version=21007
 *
 * [13] 罗马数字转整数
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
    int romanToInt(string s) {
        int result=0,preVal=1001;
        unordered_map<char, int> arr;
        arr.emplace('M',1000);
        arr.emplace('D',500);
        arr.emplace('C',100);
        arr.emplace('L',50);
        arr.emplace('X',10);
        arr.emplace('V',5);
        arr.emplace('I',1);

        for(int i=0;i<s.size();++i){
            int val = arr.at(s[i]);
            if(preVal>=val){
                result+=val;
            }else{
                result+=val-preVal*2;
            }
            preVal = val;
        }

        return result;
    }
};
// @lc code=end



/*
// @lcpr case=start
// "III"\n
// @lcpr case=end

// @lcpr case=start
// "IV"\n
// @lcpr case=end

// @lcpr case=start
// "IX"\n
// @lcpr case=end

// @lcpr case=start
// "LVIII"\n
// @lcpr case=end

// @lcpr case=start
// "MCMXCIV"\n
// @lcpr case=end

 */


