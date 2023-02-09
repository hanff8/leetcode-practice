import java.sql.Struct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1604 lang=java
 * @lcpr version=21504
 *
 * [1604] 警告一小时内使用相同员工卡大于等于三次的人
 */

// @lc code=start
class Solution {
    public int convertTime2Minutes(String times) {
        char[] cs = times.toCharArray();
        int hour = (cs[0] - '0') * 10 + (cs[1] - '0');
        int minutes = (cs[3] - '0') * 10 + (cs[4] - '0');
        return hour * 60 + minutes;
    }

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int n = keyName.length;
        ArrayList<String> result = new ArrayList<>();
        HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hashMap.computeIfAbsent(keyName[i], k -> new ArrayList<Integer>()).add(convertTime2Minutes(keyTime[i]));
        }
        for (String string : hashMap.keySet()) {
            var list = hashMap.get(string);
            Collections.sort(list);
            if (list.size() < 3)
                continue;
            for (int i = 2; i < list.size(); i++) {
                if (list.get(i) - list.get(i - 2) <= 60) {
                    result.add(string);
                    break;
                }
            }

        }
        Collections.sort(result);
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
 * //
 * ["daniel","daniel","daniel","luis","luis","luis","luis"]\n["10:00","10:40",
 * "11:00","09:00","11:00","13:00","15:00"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * //
 * ["alice","alice","alice","bob","bob","bob","bob"]\n["12:01","12:00","18:00",
 * "21:00","21:20","21:30","23:00"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // ["john","john","john"]\n["23:58","23:59","00:01"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // ["leslie","leslie","leslie","clare","clare","clare","clare"]\n["13:00",
 * "13:20","14:00","18:00","18:51","19:30","19:49"]\n
 * // @lcpr case=end
 * 
 */
