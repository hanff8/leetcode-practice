#
# @lc app=leetcode.cn id=2316 lang=python3
# @lcpr version=30102
#
# [2316] 统计无向图中无法互相到达点对数
#


# @lcpr-template-start

# @lcpr-template-end
# @lc code=start
class Solution:
    def countPairs(self, n: int, edges: List[List[int]]) -> int:
        # return self.solution1(n, edges)
        return self.solution2(n,edges)
    

    def solution2(self,n ,edges)->int:
        cnt=0
        uf = UnionFind(n)
        for x,y in edges:
            uf.union(x,y)

        for i in range(n):
            cnt+= n-uf.getSize(uf.find(i))
        return cnt//2
        
    def solution1(self, n, edges):
        cnt=0
        visited=[False]*n
        g = [[]for _ in range(n)]
        for edge in edges:
            g[edge[0]].append(edge[1])
            g[edge[1]].append(edge[0])
        def dfs(v)->int:
            visited[v] = True
            count=1
            for vv in g[v]:
                if not visited[vv]:
                    count+=dfs(vv)
            return count

        for i in range(n):
            if not visited[i]:
                cc = dfs(i)
                cnt += cc*(n-cc)
        return cnt//2

class UnionFind:
    def __init__(self,n) -> None:
        self.n = n
        self.parents=[i for i in range(n)]
        self.size=[1]*n
    def find(self,i)->int:
        if i==self.parents[i]:
            return i
        else:
            self.parents[i] = self.find(self.parents[i])
            return self.parents[i] 
    
    def union(self,x,y):
        rx = self.find(x)
        ry = self.find(y)

        if rx!=ry:
            if self.size[rx]>self.size[ry]:
                self.parents[ry] = rx
                self.size[rx]+=self.size[ry]
            else:
                self.parents[rx] = self.parents[ry]
                self.size[ry]+=self.size[rx]
    
    def getSize(self,x)->int:
        return self.size[x]

# @lc code=end



#
# @lcpr case=start
# 3\n[[0,1],[0,2],[1,2]]\n
# @lcpr case=end

# @lcpr case=start
# 7\n[[0,2],[0,5],[2,4],[1,6],[5,4]]\n
# @lcpr case=end

#

