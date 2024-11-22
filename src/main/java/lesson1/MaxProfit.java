package lesson1;

import precondition.Preconditions;

import static precondition.Preconditions.check;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int result = bruteForce(prices);
        check(result == 5);
        System.out.println(result);

        result = dynamic(prices);
        check(result == 5);
        System.out.println(result);
    }

    // O(n)
    public static int dynamic(int[] prices) {
        int lowest = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int sellingToday = prices[i] - lowest;
            profit = Math.max(profit, sellingToday);
            lowest = Math.min(prices[i], lowest);
        }
        return profit;
    }

    // O(n^2)
    public static int bruteForce(int[] prices) {
        int bestProfit = 0;
        for (int i = 0; i < prices.length -1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j] - prices[i] > bestProfit) {
                    bestProfit = prices[j] - prices[i];
                }
            }
        }
        return bestProfit;
    }
}


