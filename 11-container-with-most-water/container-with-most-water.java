class Solution {
    public int maxArea(int[] height) {
        // Two pointers: one at the start, one at the end
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0; // Stores the maximum water area found so far

        // Continue until the two pointers meet
        while (left < right) {

            // The height of the container is limited by the shorter line
            int h = Math.min(height[left], height[right]);

            // Width is the distance between the two pointers
            int width = right - left;

            // Calculate area and update maxArea if it's larger
            maxArea = Math.max(maxArea, h * width);

            // Move the pointer pointing to the shorter line,
            // hoping to find a taller line that gives a larger area
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        // Return the maximum area found
        return maxArea;
    }
}