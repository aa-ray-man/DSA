class Solution {
    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            // Target found
            if (nums[mid] == target) {
                return mid;
            }

            // Check if Left half is sorted
            if (nums[l] <= nums[mid]) {

                // Check if Target lies in the left sorted half
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                }
                // Target lies in the right half
                else {
                    l = mid + 1;
                }

            }

            // Right half is sorted
            else {

                // Check if Target lies in the right sorted half
                if (target <= nums[r] && nums[mid] < target) {
                    l = mid + 1;
                }
                // Target lies in the left half
                else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}