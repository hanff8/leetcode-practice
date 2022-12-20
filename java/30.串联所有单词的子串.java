import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=30 lang=java
 * @lcpr version=21103
 *
 * [30] 串联所有单词的子串
 */

// @lc code=start
class Solution {
    /**
     * 超时
     * 
     */
    // private void getAllStr(Set<String> arr, String[] words, int index,
    // StringBuilder sb, int[] route) {
    // if (index == words.length) {
    // arr.add(sb.toString());
    // return;
    // } else {

    // for (int i = 0; i < words.length; i++) {
    // if (route[i] == 1) {
    // continue;
    // }
    // route[i] = 1;
    // sb.append(words[i]);
    // getAllStr(arr, words, index + 1, sb, route);
    // sb.delete(sb.length() - words[i].length(), sb.length());
    // route[i] = 0;
    // }
    // }

    // }

    // public List<Integer> findSubstring(String s, String[] words) {
    // Set<String> arr = new HashSet<>();
    // List<Integer> res = new ArrayList<>();
    // StringBuilder sb = new StringBuilder();

    // int[] route = new int[words.length];
    // for (int i = 0; i < route.length; i++) {
    // route[i] = 0;
    // }
    // getAllStr(arr, words, 0, sb, route);
    // // for (String str : arr) {
    // // System.out.println(str);
    // // }

    // int str_length = words.length * words[0].length();
    // if (str_length > s.length())
    // return res;
    // for (int i = 0; i + str_length - 1 < s.length(); i++) {
    // if (arr.contains(s.substring(i, i + str_length))) {
    // res.add(i);
    // }
    // }
    // return res;

    // }
    /**
     * 用两个hashmap,一个 A 存放所有的单词String[] words,
     * 另一个 B，存放在s中能成功匹配的单词。
     * 通过判断B与A中的键值的大小来判断是否匹配完成整个由words中单词组成的String。
     * 
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> arr = new ArrayList<>();
        Map<String, Integer> wordsMap = new HashMap<String, Integer>();

        // 存入words中的词
        for (String word : words) {
            int val = wordsMap.getOrDefault(word, 0);
            wordsMap.put(word, val + 1);
        }
        int wordLength = words[0].length();
        for (int i = 0; i < s.length() - words.length * wordLength + 1; i++) {
            Map<String, Integer> strMap = new HashMap<>();
            int num = 0;
            while (num < words.length) {
                String word = s.substring(i + num * wordLength, i + wordLength * (num + 1));
                if (wordsMap.containsKey(word)) {
                    int val = strMap.getOrDefault(word, 0);
                    strMap.put(word, val + 1);

                    /**
                     * 确保words中的单词组合匹配成功，即每一个单词的数量都是正确的，当该单词数量多于wordsMap
                     * 的时候说明
                     */
                    if (strMap.get(word) > wordsMap.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }
            if (num == words.length) {
                arr.add(i);
            }
        }
        return arr;
    }
    // int des_length = words[0].length() * words.length;
    // for (int i = 0; i < s.length(); i++) {
    // String str = s.substring(i, i + des_length);
    // for (String word : words) {
    // str.substring(i, i + word.length()).equals(word);
    // }
    // }

    // }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "barfoothefoobarman"\n["foo","bar"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "wordgoodgoodgoodbestword"\n["word","good","best","word"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "barfoofoobarthefoobarman"\n["bar","foo","the"]\n
 * // @lcpr case=end
 * 
 */
