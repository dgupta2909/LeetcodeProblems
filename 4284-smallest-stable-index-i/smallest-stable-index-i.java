public class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return -1;

        // suffixMin[i] stores the minimum value from index i to n-1
        long[] suffixMin = new long[n];
        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        long currentPrefixMax = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            currentPrefixMax = Math.max(currentPrefixMax, nums[i]);

            // Instability Score: max(nums[0..i]) - min(nums[i..n-1])
            long instabilityScore = currentPrefixMax - suffixMin[i];

            if (instabilityScore <= k) {
                return i;
            }
        }

        return -1;
    }
}