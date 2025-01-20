package misc.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CarPolling {

    public static void main(String[] args) {
        int[][] trips = {{4,5,6},{6,4,7},{4,3,5},{2,3,5}};
        int capacity = 13;

        boolean result = carPooling(trips, capacity);
        System.out.println(result);
    }

    public static boolean carPooling(int[][] trips, int capacity) {
        //map - key=saida, value=passengers

        List<int[]> items = new ArrayList<>();

        for (int i = 0; i < trips.length; i++) {
            // from
            items.add(new int[]{trips[i][1], trips[i][0]});
            // to
            items.add(new int[]{trips[i][2], trips[i][0] * -1});
        }

        items.sort(Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));

        int seats = 0;

        for (var item : items) {
            seats += item[1];
            if (seats > capacity) {
                return false;
            }
        }
        return true;
    }
}
