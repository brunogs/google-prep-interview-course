package lesson14;

public class CoinChange {

    Integer[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new Integer[amount+1];
        return coinChangeIter(coins, amount);
    }

    public int coinChangeIter(int[] coins, int amount) {
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Integer.MAX_VALUE;
        }
        memo[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (i - c < 0 || memo[i - c] == Integer.MAX_VALUE) {
                    continue;
                }
                memo[i] = Math.min(memo[i], memo[i-c]+1);
            }
        }

        if (memo[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return memo[amount];
    }
}
