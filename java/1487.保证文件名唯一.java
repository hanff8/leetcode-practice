import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1487 lang=java
 * 
 * @lcpr version=21708
 *
 * [1487] 保证文件名唯一
 */

// @lc code=start
class Solution {
    public String[] getFolderNames(String[] names) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < names.length; ++i) {
            if (hashMap.containsKey(names[i])) {
                int repeat = hashMap.get(names[i]);
                while (hashMap.containsKey(names[i] + '(' + repeat + ')')) {
                    ++repeat;
                }
                hashMap.put(names[i], repeat);
                names[i] += "(" + repeat + ")";
            }
            hashMap.put(names[i], 1);

        }
        return names;
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // ["pes","fifa","gta","pes(2019)"]\n // @lcpr case=end
 * 
 * // @lcpr case=start // ["gta","gta(1)","gta","avalon"]\n // @lcpr case=end
 * 
 * // @lcpr case=start // ["onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start // ["wano","wano","wano","wano"]\n // @lcpr case=end
 * 
 * // @lcpr case=start // ["kaido","kaido(1)","kaido","kaido(1)"]\n // @lcpr case=end
 * 
 */


