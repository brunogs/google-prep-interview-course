package lesson2;

public class IsUglyI {

    public static void main(String[] args) {
        boolean result = isUgly(14);
        System.out.println(result);
    }

    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {
            if (n % 5 == 0) {
                n = n / 5;
            } else if (n % 3 == 0) {
                n = n / 3;
            } else if (n % 2 == 0) {
                n = n / 2;
            } else {
                return false;
            }
        }
        return true;
    }
}
