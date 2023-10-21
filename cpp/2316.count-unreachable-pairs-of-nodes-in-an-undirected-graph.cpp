/*
 * @lc app=leetcode.cn id=2316 lang=cpp
 * @lcpr version=30102
 *
 * [2316] 统计无向图中无法互相到达点对数
 */

// @lcpr-template-start
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
// @lcpr-template-end
// @lc code=start
class UnionFind {
  private:
    vector<int> parents;
    vector<int> sizes;

  public:
    UnionFind(int n) : parents(n), sizes(n, 1) {
        iota(parents.begin(), parents.end(), 0);
    }

    int find(int x) {
        if (parents[x] == x)
            return x;
        else {
            parents[x] = find(parents[x]);
            return parents[x];
        }
    }
    void union_val(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx != ry) {
            if (sizes[rx] > sizes[ry]) {
                parents[ry] = rx;
                sizes[rx] += sizes[ry];
            } else {
                parents[rx] = ry;
                sizes[ry] += sizes[rx];
            }
        }
    }
    int getSize(int x) { return sizes[x]; }
};
class Solution {
  private:
    vector<vector<int>> g;
    vector<bool> visited;

  public:
    long long countPairs(int n, vector<vector<int>> &edges) {
        // return solution1(n, edges);
        return solution2(n, edges);
    }
    long long solution2(int n, vector<vector<int>> &edges) {
        g = vector(n, vector<int>());
        long long res = 0;
        UnionFind uf(n);
        for (auto e : edges) {
            uf.union_val(e[0], e[1]);
        }
        for (int i = 0; i < n; ++i) {
            res += n - uf.getSize(uf.find(i));
        }
        return res / 2;
    }
    long long solution1(int n, vector<vector<int>> &edges) {
        g = vector(n, vector<int>());
        visited = vector(n, false);
        for (auto &edge : edges) {
            g[edge[0]].push_back(edge[1]);
            g[edge[1]].push_back(edge[0]);
        }
        long long res = 0;
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                long long count = dfs(i);
                res += count * (n - count);
            }
        }
        return res / 2;
    }
    long long dfs(int n) {
        visited[n] = true;
        long long count = 1;
        for (auto v : g[n]) {
            if (!visited[v]) {
                count += dfs(v);
            }
        }
        return count;
    }
};

// @lc code=end

/*
// @lcpr case=start
// 3\n[[0,1],[0,2],[1,2]]\n
// @lcpr case=end

// @lcpr case=start
// 7\n[[0,2],[0,5],[2,4],[1,6],[5,4]]\n
// @lcpr case=end

 */
