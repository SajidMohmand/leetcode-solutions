import com.sun.jdi.Value;

public class Q121 {
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;  // Store the minimum price so far
        int maxProfit = 0;  // Store the maximum profit we can achieve

        for (int i = 0; i < prices.length; i++) {
            // Update the minimum price
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            // Calculate the profit if selling at the current price and update maxProfit
            else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;  // Return the maximum profit achieved
    }

    public static void main(String[] args) {
        int[]  prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
