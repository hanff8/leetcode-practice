/*
 * @lc app=leetcode.cn id=30 lang=cpp
 * @lcpr version=21102
 *
 * [30] 串联所有单词的子串
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
#include <string>
#include <tuple>
#include <unordered_map>
#include <unordered_set>
#include <utility>
#include <vector>
using namespace std;
// @lc code=start
class Solution {
  public:
    vector<int> findSubstring(string s, vector<string> &words) {
        vector<int> res;
        unordered_map<string, int> arr;

        for (string word : words) {
            if (arr.find(word) != arr.end()) {
                arr.at(word)++;
            } else {
                arr.emplace(word, 1);
            }
        }

        int word_length = words[0].length();

        for (int i = 0; i + word_length - 1 < s.size(); ++i) {
            unordered_map<string, int> arr2;
            int num = 0;
            while (num < words.size()) {
                string str = s.substr(i + num * word_length, word_length);
                auto a = arr.find(str);
                // 如果截取的字符在给出的words中
                if (a != arr.end()) {
                    auto b = arr2.find(str);
                    if (b != arr2.end()) {
                        if (b->second < a->second) {
                            arr2.at(str)++;
                        } else {
                            break;
                        }
                    } else {
                        arr2.emplace(str, 1);
                    }
                } else {
                    break;
                }
                ++num;
            }
            if (num == words.size())
                res.push_back(i);
        }
        return res;
    }
};
// @lc code=end

/*
// @lcpr case=start
// "barfoothefoobarman"\n["foo","bar"]\n
// @lcpr case=end

// @lcpr case=start
// "wordgoodgoodgoodbestword"\n["word","good","best","word"]\n
// @lcpr case=end

// @lcpr case=start
// "barfoofoobarthefoobarman"\n["bar","foo","the"]\n
// @lcpr case=end

 */
