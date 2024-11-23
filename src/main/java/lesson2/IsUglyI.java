package lesson2;

/**
 * An ugly number is a positive integer which does not have a prime factor other than 2, 3, and 5.
 *
 * Given an integer n, return true if n is an ugly number.
 * https://leetcode.com/problems/ugly-number/description/
 */
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
