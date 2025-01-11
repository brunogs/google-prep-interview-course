package lesson14;

public class CoinChangeII {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;

        int result = change(amount, coins);
        System.out.println(result);
    }

    public static int change(int amount, int[] coins) {
        int[] memo = new int[amount+1];

        memo[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i < amount + 1; i++) {
                memo[i] += memo[i-coin];
            }
        }

        return memo[amount];
    }
}
