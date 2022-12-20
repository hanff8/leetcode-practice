/*
 * @lc app=leetcode.cn id=1764 lang=cpp
 * @lcpr version=21103
 *
 * [1764] 通过连接另一个数组的子数组得到一个数组
 */
#include <algorithm>
#include <array>
#include <bitset>
#include <climits>
#include <cmath>
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
    //贪心
    // bool check(vector<int>& g,vector<int>& nums,int k){
    //     if(k+g.size()>nums.size()){
    //         return false;
    //     }
    //     for (int j=0; j<g.size(); ++j) {
    //         if(g[j]!=nums[k+j])
    //             return false;
    //     }
    //     return true;
    // }
    // bool canChoose(vector<vector<int>>& groups, vector<int>& nums) {
    //     int i=0;
    //     for (int k=0; k<nums.size()&&i<groups.size();) {
    //             if(check(groups[i], nums, k)){
    //                 k+=groups[i].size(); 
    //                 i++;
    //             }else{
    //                 k++;
    //             }
    //     }
    //     return i==groups.size();
    // }

    //KMP
    
    int findByKMP(vector<int>& s,int k,vector<int>& p) {
        int m=p.size(),n=s.size();

        if(k+p.size()>s.size()){
            return -1;
        }
        vector<int> next(m);
        //构建next数组
        for (int i=1,j=0; i<m; i++) {
            while (j>0&&p[i]!=p[j]) {
                j=next[j-1];
            }
            if (p[i]==p[j]) {
                j++;
            }
            next[i] = j;
        }
        
        for (int i=k,j=0; i<n; i++) {
            while(j>0&&s[i]!=p[j]){
                j = next[j-1];
            }
            if(s[i]==p[j]){
                j++;
            }
            if(j==m){
                return i-m+1;
            }
        }
        return -1;
    }

    bool canChoose(vector<vector<int>>& groups, vector<int>& nums) {
        int k=0;
        for (int i=0; i<groups.size(); ++i) {
            k = findByKMP(nums,k,groups[i]);
            if(k==-1){
                return false;
            }
            k+=groups[i].size();
        }
        return true;
    }
};
// @lc code=end



/*
// @lcpr case=start
// [[1,-1,-1],[3,-2,0]]\n[1,-1,0,1,-1,-1,3,-2,0]\n
// @lcpr case=end

// @lcpr case=start
// [[10,-2],[1,2,3,4]]\n[1,2,3,4,10,-2]\n
// @lcpr case=end

// @lcpr case=start
// [[1,2,3],[3,4]]\n[7,7,1,2,3,4,7,7]\n
// @lcpr case=end

 */


