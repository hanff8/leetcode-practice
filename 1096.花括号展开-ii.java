import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=1096 lang=java
 * 
 * @lcpr version=21801
 *
 * [1096] 花括号展开 II
 */

// @lc code=start
class Solution {
    private TreeSet<String> s = new TreeSet<>();

    public List<String> braceExpansionII(String expression) {
        dfs(expression);
        return new ArrayList<>(s);
    }

    private void dfs(String exp) {
        int j = exp.indexOf('}');
        if (j == -1) {
            s.add(exp);
            return;
        }
        int i = j;
        while (exp.charAt(i) != '{') {
            --i;
        }
        String a = exp.substring(0, i);
        String c = exp.substring(j + 1);
        for (String b : exp.substring(i + 1, j).split(",")) {
            dfs(a + b + c);
        }
    }
}

// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end


/*
 * // @lcpr case=start // "{a,b}{c,{d,e}}"\n // @lcpr case=end
 * 
 * // @lcpr case=start // "{{a,z},a{b,c},{ab,z}}"\n // @lcpr case=end
 * 
 */


