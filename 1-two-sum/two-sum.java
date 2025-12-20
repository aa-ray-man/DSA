public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];  // Find the complement of the current number
            
            // Check if the complement exists in the HashMap
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            
            // Otherwise, add the current number and its index to the HashMap
            map.put(nums[i], i);
        } 
        return new int[] {}; // If no solution is found, return an empty array
    }
}
