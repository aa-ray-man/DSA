class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search on the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int l = 0;
        int r = m;

        while (l <= r) {

            int mid1 = l + (r - l) / 2;
            int mid2 = (m + n + 1) / 2 - mid1;

            int left1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int right1 = (mid1 == m) ? Integer.MAX_VALUE : nums1[mid1];

            int left2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int right2 = (mid2 == n) ? Integer.MAX_VALUE : nums2[mid2];

            // Correct partition found
            if (left1 <= right2 && left2 <= right1) {

                if ((m + n) % 2 == 1) {
                    return Math.max(left1, left2);
                }

                return ((double) Math.max(left1, left2)
                        + Math.min(right1, right2)) / 2;
            }

            // Too many elements taken from nums1
            else if (left1 > right2) {
                r = mid1 - 1;
            }

            // Too few elements taken from nums1
            else {
                l = mid1 + 1;
            }
        }

        return 0.0; // Unreachable for valid input
    }
}