class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = 0;

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int l = 1;
        int r = max;
        int ans = max;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            long hours = 0;

            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
            }

            if (hours <= h) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}