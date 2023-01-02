/*
 * @lc app=leetcode.cn id=1801 lang=cpp
 * @lcpr version=21104
 *
 * [1801] 积压订单中的订单总数
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

    //优先级队列
    int getNumberOfBacklogOrders(vector<vector<int>>& orders) {
        priority_queue<pair<int,int>> buy;
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<>> sell;

        int res=0,mod=1e9+7;
        for (auto&v : orders) {
            if(v[2]==0){
                while (v[1]&&!sell.empty()&&sell.top().first<=v[0]) {
                    auto [price,amount]=sell.top();
                    sell.pop();
                    if(amount<=v[1]){
                        res=(res-amount+mod)%mod,v[1]-=amount;
                    }else {
                        sell.push({price,amount-v[1]}),res=(res-v[1]+mod)%mod,v[1]=0;
                    }
                }
                if(v[1])
                    buy.push({v[0],v[1]}),res=(res+v[1])%mod;
            }else {
                while(v[1]&&!buy.empty()&&buy.top().first>=v[0]){
                    auto [price,amount]=buy.top();
                    buy.pop();
                    if(amount<=v[1]){
                        res=(res-amount+mod)%mod,v[1]-=amount;
                    }else {
                        buy.push({price,amount-v[1]}),res=(res-v[1]+mod)%mod,v[1]=0;
                    }
                }
                if(v[1]){
                    sell.push({v[0],v[1]}),res=(res+v[1])%mod;
                }
            }
        }
        return res;
    }
};
// @lc code=end



/*
// @lcpr case=start
// [[10,5,0],[15,2,1],[25,1,1],[30,4,0]]\n
// @lcpr case=end

// @lcpr case=start
// [[7,1000000000,1],[15,3,0],[5,999999995,0],[5,1,1]]\n
// @lcpr case=end

 */


