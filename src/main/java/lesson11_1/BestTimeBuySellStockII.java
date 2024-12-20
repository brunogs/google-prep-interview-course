package lesson11_1;

public class BestTimeBuySellStockII {

    public int maxProfit(int[] prices) {
        return greedy(prices);
    }

    public int greedy(int[] prices) {
        int profit = 0;
        int currentPrice = prices[0];

        for (int i = 0; i < prices.length; i++) {
            int difference = (prices[i] - currentPrice);
            if (difference < 0) {
                currentPrice = prices[i];
            } else if (difference > 0) {
                profit += difference;
                currentPrice = prices[i];
            }
        }
        return profit;
    }

}
