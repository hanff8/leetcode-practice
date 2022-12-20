/*
 * @lc app=leetcode.cn id=1697 lang=cpp
 * @lcpr version=21007
 *
 * [1697] 检查边长度限制的路径是否存在
 */
#include <algorithm>
#include <array>
#include <bitset>
#include <climits>
#include <deque>
#include <functional>
#include <iostream>
#include <list>
#include <numeric>
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

    int find(vector<int> &uf,int x){
        if(uf[x] == x){
            return x;
        }
        return uf[x] = find(uf,uf[x]);
    }

    void merge(vector<int> &uf,int x,int y){
        x = find(uf,x);
        y = find(uf,y);
        uf[y] = x;
    }

    vector<bool> distanceLimitedPathsExist(int n, vector<vector<int>>& edgeList, vector<vector<int>>& queries) {
        
        sort(edgeList.begin(),edgeList.end(),[](vector<int> &e1,vector<int> &e2){
            return e1[2]<e2[2];
        });

        
        vector<int> index(queries.size());
        iota(index.begin(), index.end(), 0);

        //注意这一步，对queries进行递增排序，
        sort(index.begin(), index.end(), [&](int i1,int i2){
            return queries[i1][2]<queries[i2][2];
        });
        
        //初始化并查集 uf
        vector<int> uf(n);
        iota(uf.begin(),uf.end(),0);
        
        vector<bool> res(queries.size());
        int k=0;
        for (auto i : index) {
            // 将边权小于limit的edgelist加入并查集
            while(k<edgeList.size()&&edgeList[k][2]<queries[i][2]){
                merge(uf,edgeList[k][0],edgeList[k][1]);
                k++;
            }
            //如果两者相等，说明在并查集中具有相同的根节点，即成功在edgelist组成的并查集中找到答案。
            res[i] = find(uf,queries[i][0]) == find(uf,queries[i][1]);

        }
        return res;

    }
};
// @lc code=end



/*
// @lcpr case=start
// 3\n[[0,1,2],[1,2,4],[2,0,8],[1,0,16]]\n[[0,1,2],[0,2,5]]\n
// @lcpr case=end

// @lcpr case=start
// 5\n[[0,1,10],[1,2,5],[2,3,9],[3,4,13]]\n[[0,4,14],[1,4,13]]\n
// @lcpr case=end

 */


