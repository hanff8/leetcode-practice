import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        // int n = nums.length;
        // int[] prefixSum = new int[n + 1];
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < n; ++i) {
        // prefixSum[i + 1] = prefixSum[i] + nums[i];
        // }
        // int ans = 0;
        // for (int left = 0; left <= n;) {
        // int right = left + 1;
        // while (right <= n) {
        // if (prefixSum[right] - prefixSum[left] == k) {
        // ++ans;
        // // break;
        // }
        // right++;
        // }
        // left++;
        // }
        // return ans;
        int count = 0, pre = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (hashMap.containsKey(pre - k)) {
                count += hashMap.get(pre - k);
            }
            hashMap.put(pre, hashMap.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
