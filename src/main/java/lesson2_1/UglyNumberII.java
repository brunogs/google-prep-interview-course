package lesson2_1;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 * Given an integer n, return the nth ugly number.
 */
public class UglyNumberII {

    public static void main(String[] args) {
        int n = 1407;
        int result = nthUglyNumber(n);

        System.out.println(result);
    }

    public static int nthUglyNumber(int n) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        long[] out = new long[n];
        heap.add(1l);
        int i = 0;
        while (i < n) {
            long lower = heap.poll();
            while (i > 1 && lower == out[i-1]) {
                lower = heap.poll();
            }
            heap.add(lower * 2);
            heap.add(lower * 3);
            heap.add(lower * 5);
            out[i] = lower;
            i++;
        }
        System.out.println(Arrays.toString(out));

        return (int) out[n-1];
    }
}
