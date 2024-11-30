package lesson4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GraphList {

    public static void main(String[] args) {
        var g = new Graph(6);
        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(1, 4);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 2);
        g.addEdge(2, 4);
        g.addEdge(4, 2);
        g.addEdge(2, 5);
        g.addEdge(5, 2);
        g.addEdge(3, 5);
        g.addEdge(5, 3);
        g.addEdge(4, 5);
        g.addEdge(5, 4);

        System.out.println(g.bfs(new Node(1, 0)));
    }

    public record Node(int val, int weight){}

    public static class Graph {
        int V;
        int E;
        Map<Integer, Set<Node>> adj;

        public Graph(int V) {
            this.V = V;
            this.E = 0;
            adj = new HashMap<>();
        }

        public void addEdge(Integer name, int val){
            this.E++;
            adj.putIfAbsent(name, new HashSet<>());
            adj.get(name).add(new Node(val, 0));
        }

        public List<Integer> bfs(Node node) {
            Queue<Node> queue = new LinkedList<>();
            Map<Integer, Boolean> visited = new HashMap<>();
            queue.add(node);
            visited.put(node.val, true);

            List<Integer> listVisitedNodes = new ArrayList<>();

            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                listVisitedNodes.add(cur.val);
                System.out.println("Working with node " + cur);
                Set<Node> neighbors = adj.getOrDefault(cur.val, new HashSet<>());
                for (Node neighbor : neighbors) {
                    if (!visited.getOrDefault(neighbor.val, false)) {
                        visited.put(cur.val, true);
                        queue.add(neighbor);
                    } else {
                        System.out.println("Node already visited " + neighbor);
                    }
                }
            }
            return listVisitedNodes;
        }

    }
}
