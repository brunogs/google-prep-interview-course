package lesson11;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Prim {

    int source = 0;
    int target = 1;
    int weight = 2;

    Prim() {

    }

    public int solve(int[][] graph) {
        int[] dist = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        boolean[] visited = new boolean[graph.length];

        dist[0] = 0;
        int total = 0;
        visited[0] = true;

        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> dist[a[0]]));
        heap.add(new int[]{0, 0});// node = 0, weight = 0

        while (!heap.isEmpty()) {
            int[] current = heap.poll();
            int node = current[0];
            int cost = current[1];

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            total += cost;

            for (var path : graph) {
                if (path[source] == node && !visited[path[target]]) {
                    int weightNode = path[weight];
                    if (weightNode < dist[node]) {
                        dist[node] = weightNode;
                    }
                    heap.add(new int[]{path[target], dist[node]});// node = 0, weight = 0
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {

    }
}
