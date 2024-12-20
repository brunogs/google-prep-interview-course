package lesson11_1;

public class CoinChange {

    static Integer[] memo;

    public static void main(String[] args) {
        //int[] coins = {1,2,5};
        //int amount = 11;

        int[] coins = {186,419,83,408};
        int amount = 6249;

        var result = coinChange(coins, amount);
        System.out.println(result);
    }

    public static int coinChange(int[] coins, int amount) {
        memo = new Integer[amount+1];
        return coinChangeDP(coins, amount);
    }

    //[1,2,5], amount = 11

    public static int coinChangeDP(int[] coins, int amount) {
        //System.out.println(" current amount is " + amount + " and count is " + count);
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != null) {
            System.out.println("memo used for " + amount + " and count is " + memo[amount]);
            return memo[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int partial = coinChangeDP(coins, amount - coin);
            if (partial != -1) {
                min = Math.min(min, partial + 1);
            }
        }
        memo[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return memo[amount];
    }
}
