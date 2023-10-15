//现有一个有向图，其中包含 n 个节点，节点编号从 0 到 n - 1 。此外，该图还包含了 n 条有向边。 
//
// 给你一个下标从 0 开始的数组 edges ，其中 edges[i] 表示存在一条从节点 i 到节点 edges[i] 的边。 
//
// 想象在图上发生以下过程： 
//
// 
// 你从节点 x 开始，通过边访问其他节点，直到你在 此过程 中再次访问到之前已经访问过的节点。 
// 
//
// 返回数组 answer 作为答案，其中 answer[i] 表示如果从节点 i 开始执行该过程，你可以访问到的不同节点数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：edges = [1,2,0,0]
//输出：[3,3,3,4]
//解释：从每个节点开始执行该过程，记录如下：
//- 从节点 0 开始，访问节点 0 -> 1 -> 2 -> 0 。访问的不同节点数是 3 。
//- 从节点 1 开始，访问节点 1 -> 2 -> 0 -> 1 。访问的不同节点数是 3 。
//- 从节点 2 开始，访问节点 2 -> 0 -> 1 -> 2 。访问的不同节点数是 3 。
//- 从节点 3 开始，访问节点 3 -> 0 -> 1 -> 2 -> 0 。访问的不同节点数是 4 。
// 
//
// 示例 2： 
// 
// 
//输入：edges = [1,2,3,4,0]
//输出：[5,5,5,5,5]
//解释：无论从哪个节点开始，在这个过程中，都可以访问到图中的每一个节点。
// 
//
// 
//
// 提示： 
//
// 
// n == edges.length 
// 2 <= n <= 10⁵ 
// 0 <= edges[i] <= n - 1 
// edges[i] != i 
// 
//
// 👍 3 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] countVisitedNodes(List<Integer> edges) {
        /**
         * 建立入度表，建立g的反图
         */
        var n = edges.size();
        int[] g = edges.stream().mapToInt(Integer::intValue).toArray();
        var indegree = new int[n];
        List<Integer>[] rg = new ArrayList[n];
        Arrays.setAll(rg, a->new ArrayList<>());
        for (int i = 0; i <n; i++) {
            rg[g[i]].add(i);
            indegree[g[i]]++;
        }

        /**
         * 减去入度为0的树枝
         */
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i]==0) {
                deque.add(i);
            }
        }

        while(!deque.isEmpty()){
            int x= deque.poll(),y=g[x];
            if(--indegree[y]==0){
                deque.add(y);
            }
        }
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if (indegree[i]<=0) {
                continue;
            }
            var ring = new ArrayList<Integer>();
            for (int x = i;; x=g[x]) {
                indegree[x] = -1;
                ring.add(x);
                if(g[x]==i){
                    break;
                }
            }
            for(int r:ring){
                rdfs(r,ring.size(),rg,indegree,ans);
            }
        }
        return ans;
    }

    private void rdfs(int x, int depth, List<Integer>[] rg, int[] indegree, int[] ans) {
        ans[x] = depth;
        for(int y:rg[x]){
            if (indegree[y]==0) {
                rdfs(y,depth+1,rg,indegree,ans);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
