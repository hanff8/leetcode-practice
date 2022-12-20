/*
 * @lc app=leetcode.cn id=1832 lang=cpp
 * @lcpr version=21004
 *
 * [1832] 判断句子是否为全字母句
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
    // bool checkIfPangram(string sentence) {
    //     std::vector<int> arr(26);
    //     for(int i=0;i<sentence.size();++i){
    //         arr[sentence[i]-'a']++;
    //     }
    //     for(int a:arr){
    //         if(a==0)
    //             return false;
    //     }
    //     return true;
    // }

    // 使用掩码
    //  bool checkIfPangram(string sentence){
    //      int state=0;
    //      for(auto a:sentence){
    //          state|=1<<(a-'a');
    //      }
    //      // 1<<26-1 ---->> 1111 1111 1111 1111 1111 1111 11 26位
    //      return state == (1<<26)-1;
    //  }
    //  使用set ,将字符转先转换成set然后判断size大小即可
    bool checkIfPangram(string sentence) {
        unordered_set<char> letters(sentence.begin(), sentence.end());
        if (letters.size() == 26)
            return true;
        return false;
    }
};
// @lc code=end

/*
// @lcpr case=start
// "thequickbrownfoxjumpsoverthelazydog"\n
// @lcpr case=end

// @lcpr case=start
// "leetcode"\n
// @lcpr case=end

 */
