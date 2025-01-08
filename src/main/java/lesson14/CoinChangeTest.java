package lesson14;

public class CoinChangeTest {

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = {2};

        int result = coinChange.coinChange(coins, 3);

        System.out.println(result);
    }
}
