class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int max = 0;
        int sum = 0;

        // Find minimum and maximum possible capacity
        for (int weight : weights) {
            max = Math.max(max, weight);
            sum += weight;
        }

        int l = max;
        int r = sum;
        int ans = sum;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            int daysNeeded = 1;
            int currentWeight = 0;

            for (int weight : weights) {

                if (currentWeight + weight > mid) {
                    daysNeeded++;
                    currentWeight = weight;
                } else {
                    currentWeight += weight;
                }
            }

            if (daysNeeded <= days) {
                // Capacity works; try a smaller one
                ans = mid;
                r = mid - 1;
            } else {
                // Capacity is too small
                l = mid + 1;
            }
        }

        return ans;
    }
}