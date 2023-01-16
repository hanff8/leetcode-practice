import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1813 lang=java
 * @lcpr version=21108
 *
 * [1813] 句子相似性 III
 */

// @lc code=start
class Solution {
    // 前后双指针
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] arr1 = sentence1.split(" ");
        String[] arr2 = sentence2.split(" ");
        int i = 0, j = 0;
        while (i < arr1.length && i < arr2.length && arr1[i].equals(arr2[i])) {
            i++;
        }
        while (j < arr1.length - i && j < arr2.length - i
                && arr1[arr1.length - j - 1].equals(arr2[arr2.length - j - 1])) {
            j++;
        }
        return (i + j) == Math.min(arr1.length, arr2.length);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "My name is Haley"\n"My Haley"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "of"\n"A lot of words"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "Eating right now"\n"Eating"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "Luky"\n"Lucccky"\n
 * // @lcpr case=end
 * 
 */
