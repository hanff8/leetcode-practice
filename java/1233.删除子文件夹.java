import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1233 lang=java
 * @lcpr version=21504
 *
 * [1233] 删除子文件夹
 */

// @lc code=start
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        ArrayList<String> result = new ArrayList<>();
        Arrays.sort(folder);
        result.add((folder[0]));
        for (int i = 1; i < folder.length; i++) {
            StringBuilder sb = new StringBuilder(result.get(result.size() - 1)).append('/');
            if (!folder[i].startsWith(sb.toString()))
                result.add(folder[i]);
        }
        return result;
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end

/*
 * // @lcpr case=start
 * // ["/a","/a/b","/c/d","/c/d/e","/c/f"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // ["/a","/a/b/c","/a/b/d"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // ["/a/b/c","/a/b/ca","/a/b/d"]\n
 * // @lcpr case=end
 * 
 */
