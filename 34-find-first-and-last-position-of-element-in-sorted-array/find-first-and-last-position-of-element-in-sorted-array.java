class Solution {
    public int[] searchRange(int[] nums, int target) {

        int n = nums.length;

        // Find first occurrence
        int l = 0, r = n - 1;
        int first = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                first = mid;
                r = mid - 1; // go left
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        // Find last occurrence
        l = 0;
        r = n - 1;
        int last = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                last = mid;
                l = mid + 1; // go right
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return new int[] { first, last };
    }
}