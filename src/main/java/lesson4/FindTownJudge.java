package lesson4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTownJudge {

    public static void main(String[] args) {
        int[][] graph = {{1,3},{2,3}};
        int result = findJudge(3, graph);
        System.out.println(result);
    }

    public static int findJudge(int n, int[][] trust) {

        Graph g = new Graph(trust.length);
        for (int i = 0; i < trust.length; i++) {
            g.addEdge(trust[i][0], trust[i][1]);
        }

        if (g.adj.isEmpty() && n > 1) {
            return -1;
        }

        int judgeCandidate = -1;
        for (int i = 1; i <= n; i++) {
            if (!g.adj.containsKey(i)) {
                judgeCandidate = i;
            }
        }
        for (Integer key : g.adj.keySet()) {
            if (!g.adj.get(key).contains(judgeCandidate)) {
                return -1;
            }
        }
        return judgeCandidate;
    }

    public record Node(int val, int weight){}

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
