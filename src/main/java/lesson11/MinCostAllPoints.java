package lesson11;

import java.util.PriorityQueue;

public class MinCostAllPoints {

    int source = 0;
    int target = 1;
    int weight = 2;

    public int minCostConnectPoints(int[][] points) {

        int[] dist = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }


        int n = points.length;
        int[][] distances = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    distances[i][j] = Math.abs(points[i][0] - points[j][0])
                            + Math.abs(points[i][1] - points[j][1]);
                }
            }
        }

        boolean[] visited = new boolean[points.length];

        distances[0][0] = 0;
        int total = 0;
        int edgesUsed = 0;
        //visited[0] = true;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        heap.add(new int[]{0, 0});// node = 0, weight = 0

        while (!heap.isEmpty() && edgesUsed < n) {
            int[] current = heap.poll();
            int node = current[0];
            int cost = current[1];

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            total += cost;
            edgesUsed++;

            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (!visited[neighbor]) {
                    int weight = distances[node][neighbor];
                    if (weight < dist[neighbor]) {
                        dist[neighbor] = weight;
                        heap.add(new int[]{neighbor, weight});
                    }
                }
            }
        }
        return total;
    }
}
