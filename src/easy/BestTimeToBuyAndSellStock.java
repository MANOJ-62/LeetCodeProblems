package easy;

/**
    Leetcode 121
    Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */
public class BestTimeToBuyAndSellStock {

   int[] prices = {7,1,5,3,6,4};
   int[] prices2 = {7,6,4,3,1};

    public int maxProfit(int[] prices) {

        // Initialize minPrice to the largest possible value
        int minPrice = Integer.MAX_VALUE;

        // This will store the maximum profit found so far
        int maxProfit = 0;

        // Iterate through the prices
        for (int price : prices) {
            // If we find a new minimum price, update minPrice
            if (price < minPrice) {
                minPrice = price;
            }
            // Otherwise, calculate profit and update maxProfit if it's higher
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        // Return the highest profit found
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        System.out.println("Max Profit : " + bestTimeToBuyAndSellStock.maxProfit(bestTimeToBuyAndSellStock.prices));
    }
}
