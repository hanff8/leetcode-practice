import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=227 lang=java
 * 
 * @lcpr version=21906
 *
 * [227] 基本计算器 II
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        // 存放数字
        Deque<Integer> nums = new ArrayDeque<>();
        // 存放操作符
        Deque<Character> ops = new ArrayDeque<>();
        Map<Character, Integer> map = Map.of('-', 1, '+', 1, '*', 2, '/', 2, '%', 2, '^', 3);


        // 去掉空格
        s = s.replaceAll(" ", "");
        int n = s.length();
        char[] cs = s.toCharArray();
        // 防止负数
        nums.push(0);
        for (int i = 0; i < n; i++) {
            char ch = cs[i];
            if (ch == '(') {
                ops.push(ch);
            } else if (ch == ')') {
                while (!ops.isEmpty()) {
                    if (ops.peek() != '(') {
                        calc(nums, ops);
                    } else {
                        ops.poll();
                        break;
                    }

                }
            } else {
                if (Character.isDigit(ch)) {
                    int u = 0;
                    int j = i;
                    while (j < n && Character.isDigit(cs[j]))
                        u = u * 10 + (cs[j++] - '0');
                    nums.push(u);
                    i = j - 1;
                } else {
                    if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                        nums.push(0);
                    }
                    while (!ops.isEmpty() && ops.peek() != '(') {
                        char prev = ops.peek();
                        if (map.get(prev) >= map.get(ch)) {
                            calc(nums, ops);
                        } else {
                            break;
                        }
                    }
                    ops.push(ch);
                }
            }
        }
        while (!ops.isEmpty())
            calc(nums, ops);
        return nums.peek();

    }

    public void calc(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2 || ops.isEmpty())
            return;
        int b = nums.poll(), a = nums.poll();
        char op = ops.poll();
        int ans = 0;
        switch (op) {
            case '+':
                ans = a + b;
                break;
            case '-':
                ans = a - b;
                break;
            case '*':
                ans = a * b;
                break;
            case '/':
                ans = a / b;
                break;
            case '^':
                ans = (int) Math.pow(a, b);
                break;
            case '%':
                ans = a % b;
                break;
        }
        nums.push(ans);
    }
}
// @lc code=end



/*
 * // @lcpr case=start // "3+2*2"\n // @lcpr case=end
 * 
 * // @lcpr case=start // " 3/2 "\n // @lcpr case=end
 * 
 * // @lcpr case=start // " 3+5 / 2 "\n // @lcpr case=end
 * 
 */

