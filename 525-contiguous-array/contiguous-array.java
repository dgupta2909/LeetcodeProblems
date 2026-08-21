import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); 

        int maxLen = 0;
        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            
            prefixSum += (nums[i] == 1 ? 1 : -1);

            if (map.containsKey(prefixSum)) {
                
                maxLen = Math.max(maxLen, i - map.get(prefixSum));
            } else {

                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {0,1,0,1,1,0,0};
        System.out.println("Max length of balanced subarray: " + sol.findMaxLength(arr));
    }
}