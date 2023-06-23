/*
 * @lc app=leetcode.cn id=1483 lang=java
 * 
 * @lcpr version=21909
 *
 * [1483] 树节点的第 K 个祖先
 */

// @lc code=start
class TreeAncestor {

    static final int LOG = 16;
    int[][] ancestors;

    public TreeAncestor(int n, int[] parent) {
        ancestors = new int[n][LOG];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ancestors[i], -1);
        }
        for (int i = 0; i < n; i++) {
            ancestors[i][0] = parent[i];
        }
        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                if (ancestors[i][j - 1] != -1) {
                    ancestors[i][j] = ancestors[ancestors[i][j - 1]][j - 1];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int j = 0; j < LOG; j++) {
            if (((k >> j) & 1) != 0) {
                node = ancestors[node][j];
                if (node == -1) {
                    return -1;
                }
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such: TreeAncestor obj = new
 * TreeAncestor(n, parent); int param_1 = obj.getKthAncestor(node,k);
 */
// @lc code=end



/*
// @lcpr case=start
// ["TreeAncestor","getKthAncestor","getKthAncestor","getKthAncestor"][[7,[-1,0,0,1,1,2,2]],[3,1],[5,2],[6,3]]\n
// @lcpr case=end

 */

