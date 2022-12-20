import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=17 lang=java
 * @lcpr version=21103
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    private void solve(List<String> answer,StringBuilder ans,Map<Character,String> numpad,
    int index,String digits) {
        if(index==digits.length()){
            answer.add(ans.toString());
            return;
        }else{
            //重要 str 每次递归都被新赋值
            String str = numpad.get(digits.charAt(index));
            for (int i = 0; i < str.length(); i++) {
                ans.append(str.charAt(i));
                solve(answer, ans, numpad, index+1, digits);
                ans.deleteCharAt(ans.length()-1);
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        Map<Character,String> NumPad = new HashMap<>(){{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }};
        if(digits.isEmpty()){
            return answer;
        }
        StringBuilder ans = new StringBuilder();
        solve(answer, ans, NumPad, 0, digits);

        return answer;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "23"\n
// @lcpr case=end

// @lcpr case=start
// ""\n
// @lcpr case=end

// @lcpr case=start
// "2"\n
// @lcpr case=end

 */


