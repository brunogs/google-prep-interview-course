package lesson4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphBipartite {

    public static void main(String[] args) {
        //int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        //int [][] graph = {{1,2},{0,2},{0,1}};
        //int [][] graph = {{1},{0,3},{3},{1,2}};
        //int [][] graph = {{3},{2,4},{1},{0,4},{1,3}};
        int [][] graph = {{1},{0,3},{3},{1,2}};
        var result = isBipartite(graph);

        System.out.println(result);
    }

    public static boolean isBipartite(int[][] graph) {
        Map<Integer, String> visited = new HashMap<>();

        for (int i = 0; i < graph.length; i++) {
            if (visited.get(i) != null) {
                continue;
            }
            boolean result = dfs(graph, i, visited, "green");
            if (!result) {
                return false;
            }
        }
        return true;
    }

    public static boolean dfs(int[][] graph, Integer i, Map<Integer, String> visited, String color) {
        visited.put(i, color);

        color = color.equals("green") ? "red" : "green";

        for (int neigh : graph[i]) {
            if (visited.getOrDefault(neigh, "").equals(visited.get(i))) {
                return false;
            } else if (visited.get(neigh) == null) {
                boolean neighResult = dfs(graph, neigh, visited, color);
                if (!neighResult) {
                    return false;
                }
            }
        }
        return true;
    }

    public static class Graph {
        int V;
        int E;
        Map<Integer, Set<Integer>> adj;

        public Graph(int V) {
            this.V = V;
            this.E = 0;
            adj = new HashMap<>();
        }

        public void addEdge(Integer name, int val){
            this.E++;
            adj.putIfAbsent(name, new HashSet<>());
            adj.get(name).add(val);
        }
    }
}
