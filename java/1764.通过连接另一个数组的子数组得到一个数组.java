/*
 * @lc app=leetcode.cn id=1764 lang=java
 * @lcpr version=21103
 *
 * [1764] 通过连接另一个数组的子数组得到一个数组
 */

// @lc code=start
class Solution {
    //贪心
    // private Boolean findArr(int[] group,int[] nums,int k){
    //     if(k+group.length>nums.length){
    //         return false;
    //     }
    //     for (int i = 0; i < group.length;++i) {
    //         if(group[i]!=nums[k+i]){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    // public boolean canChoose(int[][] groups, int[] nums) {
    //     int i=0;
    //     for (int k = 0; k < nums.length&&i<groups.length;) {
    //         //查看groups[i]是否在nums中有匹配

    //         //匹配成功
    //         if(findArr(groups[i], nums, k)){
    //             //k 跳过group[i].length
    //             k += groups[i].length;
    //             //匹配下一组
    //             i++;
    //         }else{
    //             k++;
    //         }
    //     }
    //     return i==groups.length;
    // }

    //KMP
    private int findByKMP(int[] desStr,int[] paStr,int k){
        if(k+paStr.length>desStr.length){
            return -1;
        }
        
        //构建next数组
        int[] next = new int[paStr.length];
        for(int i=1,j=0;i<paStr.length;++i){
            while (j>0&&paStr[i]!=paStr[j]) {
                j = next[j-1];
            }
            if (paStr[i]==paStr[j]) {
                j++;
            }
            next[i] = j;
        }

        for(int m=k,n=0;m<desStr.length;++m){
            while (n>0&&desStr[m]!=paStr[n]) {
                n = next[n-1];
            }
            if(desStr[m]==paStr[n]){
                ++n;
            }

            if(n==paStr.length){
                return m-paStr.length+1;
            }
        }
        return -1;
    }

    public boolean canChoose(int[][] groups, int[] nums) {
        int i=0;
        for (int j = 0; j < groups.length; j++) {
            i = findByKMP(nums,groups[j],i);
            if (i==-1) {
                return false;
            }
            i+=groups[j].length;
        }
        return true;
    }

}
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


