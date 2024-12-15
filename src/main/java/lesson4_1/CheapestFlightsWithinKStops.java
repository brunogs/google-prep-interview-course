package lesson4_1;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class CheapestFlightsWithinKStops {

    int source = 0;
    int target = 1;
    int price = 2;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Set<Integer> visited = new HashSet<>();

        int cost = 0;
        Integer result = null;

        /*
        [[0,1,2],[1,2,1],[2,0,10]]
        k = 1
        src = 1
        dst = 2

        cost = 3
        heap = [4,5], [1, 9]
        */

        while (k >= 0 || !heap.isEmpty()) { //0

            if (k >= 0) {
                nextPath(n, flights, src, heap, cost);
            }

            if (heap.isEmpty()) {
                return -1;
            }

            int[] bestPath = heap.poll();
            src = bestPath[0];
            cost = bestPath[1];
            //System.out.println(src + " _ cost = " + cost + " k = " + k);

            if (src == dst) {
                result = result == null ? cost : Math.min(result, cost);
            }
            k--;
        }

        // check if the dst is in the heap

        return result != null ? result : -1;
    }

    private void nextPath(int n, int[][] flights, int src, PriorityQueue<int[]> heap, int currentCost) {
        for (int i = 0; i < flights.length; i++) {
            if (flights[i][source] == src) {
                heap.add(new int[]{flights[i][target], currentCost + flights[i][price]});
            }
        }
    }
}
