//给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子字符串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子字符串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// 
//
// 
// 注意：本题与主站 3 题相同： https://leetcode-cn.com/problems/longest-substring-without-
//repeating-characters/ 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 98 👎 0

  
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WtcaE1{
   public static void main(String[] args) {
       Solution solution = new WtcaE1().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 同向滑动窗口
     * 一般模板 left,right同向指针，枚举right
     * 碰到相同的节点则删去并且left++
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=  new HashSet<>();
        int n = s.length();
        char[] chs = s.toCharArray();
        int len = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            while(set.contains(chs[right])){
                set.remove(chs[left++]);
            }
            set.add(chs[right]);
            len = Math.max(len,right-left+1);
        }
        return len;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
