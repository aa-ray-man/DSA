class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = 0;

        // Find maximum pile
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int l = 1;
        int r = max;
        int ans = max;

        while (l <= r) {

            int k = l + (r - l) / 2;

            long hours = 0;

            // Calculate hours needed at speed k
            for (int pile : piles) {
                hours += (pile + k - 1) / k;
            }

            if (hours <= h) {
                // k works, but try a smaller speed
                ans = k;
                r = k - 1;
            } else {
                // k is too slow
                l = k + 1;
            }
        }

        return ans;
    }
}