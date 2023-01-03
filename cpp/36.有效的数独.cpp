/*
 * @lc app=leetcode.cn id=36 lang=cpp
 * @lcpr version=21104
 *
 * [36] 有效的数独
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
    bool isValidSudoku(vector<vector<char>>& board) {
        unordered_set<char> arr;
        
        // row
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; ++j) {
                if(board[i][j]!='.'){
                    if(arr.count(board[i][j])){
                        return false;
                    }
                    arr.insert(board[i][j]);
                }
            }
            arr.clear();
        }

        //column
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; ++j) {
                if(board[j][i]!='.'){
                    if(arr.count(board[j][i])){
                        return false;
                    }
                    arr.insert(board[j][i]);
                }
            }
            arr.clear();
        }

        //square
        for(int i=0;i<9;++i){
            for(int j=0;j<3;++j){
                char ch=board[i][j];
                if(ch!='.'){
                    if(arr.count(ch)){
                        return false;
                    }
                    arr.insert(ch);
                }
            }
             if((i+1)%3==0){
                arr.clear();
            }
        }

        for(int i=0;i<9;++i){
            for(int j=3;j<6;++j){
                char ch=board[i][j];
                if(ch!='.'){
                    if(arr.count(ch)){
                        return false;
                    }
                    arr.insert(ch);
                }
            }
            if((i+1)%3==0){
                arr.clear();
            }
        }
       

        for(int i=0;i<9;++i){
            for(int j=6;j<9;++j){
                char ch=board[i][j];
                if(ch!='.'){
                    if(arr.count(ch)){
                        return false;
                    }
                    arr.insert(ch);
                }
            }
            if((i+1)%3==0){
                arr.clear();
            }
        }
        return true;
    }
};
// @lc code=end



/*
// @lcpr case=start
// [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]\n
// @lcpr case=end

// @lcpr case=start
// [["8","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]\n
// @lcpr case=end

 */


