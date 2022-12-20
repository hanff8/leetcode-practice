/*
 * @lc app=leetcode.cn id=1781 lang=cpp
 * @lcpr version=21004
 *
 * [1781] 所有子字符串美丽值之和
 */
#include <cstdint>
#include <string>
#include <unordered_map>
#include <vector>
using namespace std;
// @lc code=start
class Solution {
public:
  int beautySum(string s) {
    int result = 0;
    for (int i = 0; i < s.size(); i++) {
      vector<int> arr(26);
      int maxFreq = 0;
      for (int j = i; j < s.size(); j++) {
        arr[s[j] - 'a']++;
        maxFreq = max(maxFreq, arr[s[j] - 'a']);
        int minFreq = s.size();
        for (int k = 0; k < 26; k++) {
          if (arr[k] > 0) {
            minFreq = min(minFreq, arr[k]);
          }
        }
        result += (maxFreq - minFreq);
      }
    }
    return result;
  }
};
// @lc code=end

/*
// @lcpr case=start
// "aabcb"\n
// @lcpr case=end

// @lcpr case=start
// "aabcbaa"\n
// @lcpr case=end

 */
