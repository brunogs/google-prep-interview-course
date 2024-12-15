package lesson4_1;

import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops {

    int source = 0;
    int target = 1;
    int price = 2;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        heap.add(new int[]{src, 0, 0});

        while (!heap.isEmpty()) { //0

            int[] current = heap.poll();

            int node = current[0];
            int cost = current[1];
            int stops = current[2];

            if (node == dst) {
                return cost;
            }

            if (stops > k) {
                continue;
            }

            // next paths
            for (int[] flight : flights) {
                if (flight[source] == node) {
                    heap.add(new int[]{flight[target], cost + flight[price], stops + 1});
                }
            }
        }

        return -1;
    }
}
