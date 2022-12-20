/*
 * @lc app=leetcode.cn id=17 lang=cpp
 * @lcpr version=21007
 *
 * [17] 电话号码的字母组合
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
#include <unordered_map>
class Solution {
public:
    // void storeToque(queue<string>& que,string str,int num){
    //     if(que.empty()){
    //         for(char c:str){
    //             string temp(1,c);
    //             que.push(temp);
    //         }
    //     }else{
    //         while(que.front().size()<num+1){
    //             for(int i=0;i<str.size();++i){
    //                 string a = que.front();
    //                 a+=str[i];
    //                 que.push(a);
    //             }
    //             que.pop();
    //         }
    //     }

    // }
    // vector<string> letterCombinations(string digits) {
    //     vector<string> result;
    //     if(digits.empty()){
    //         return result;
    //     }
    //     unordered_map<char, string> arr={
    //         {'2',"abc"},
    //         {'3',"def"},
    //         {'4',"ghi"},
    //         {'5',"jkl"},
    //         {'6',"mno"},
    //         {'7',"pqrs"},
    //         {'8',"tuv"},
    //         {'9',"wxyz"}
    //     };
    //     queue<string> myque;
    //     for(int i=0;i<digits.size();++i){
    //         storeToque(myque,arr[digits[i]],i);
    //     }

    //     while(!myque.empty()){
    //         result.push_back(myque.front());
    //         myque.pop();
    //     }
    //     return result;
    // }

    void solver(string digits, vector<string>& answer, unordered_map<char,string> numpad,
    int index,string& ans ){
        
        if(index==digits.length()){
            answer.push_back(ans);
        }else {
            char digit= digits[index];
            const string& arr = numpad.at(digit);
            
            for (const char& c : arr) {
                ans.push_back(c);
                solver(digits,answer,numpad,index+1,ans);
                ans.pop_back();
            }
        }

    }

    vector<string> letterCombinations(string digits){
        vector<string> answer;
        if(digits.empty())
            return answer;
        unordered_map<char, string> arr={
            {'2',"abc"},
            {'3',"def"},
            {'4',"ghi"},
            {'5',"jkl"},
            {'6',"mno"},
            {'7',"pqrs"},
            {'8',"tuv"},
            {'9',"wxyz"}
        };
        string ans;
        solver(digits, answer, arr,0,ans);    

        return answer;

    }


    

};
// @lc code=end



/*
// @lcpr case=start
// "23"\n
// @lcpr case=end

// @lcpr case=start
// ""\n
// @lcpr case=end

// @lcpr case=start
// "2"\n
// @lcpr case=end

 */


