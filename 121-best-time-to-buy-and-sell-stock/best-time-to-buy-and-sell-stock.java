class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;           // Track lowest price so far
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; // Update max profit if selling today is better
            }
        }

        return maxProfit;
    }
}
