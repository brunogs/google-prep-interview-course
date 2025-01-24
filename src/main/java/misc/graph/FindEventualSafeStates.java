package misc.graph;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {

    public static void main(String[] args) {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer> result = eventualSafeNodes(graph);
        System.out.println(result);
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n]; // 0: unvisited, 1: visiting, 2: safe
        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (isSafe(i, graph, state)) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    private static boolean isSafe(int node, int[][] graph, int[] state) {
        // If the node is already visited, return its state
        if (state[node] != 0) {
            return state[node] == 2;
        }

        // Mark the node as visiting (part of the current DFS path)
        state[node] = 1;

        // Check all neighbors
        for (int neighbor : graph[node]) {
            if (!isSafe(neighbor, graph, state)) {
                return false; // If any neighbor is not safe, this node is not safe
            }
        }

        // If all neighbors are safe, mark this node as safe
        state[node] = 2;
        return true;
    }
}
