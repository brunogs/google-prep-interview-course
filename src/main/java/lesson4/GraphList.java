package lesson4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphList {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        //graph.containsKey()
    }

    public record Node(int val, int weight){}

    public class Graph {
        int V;
        int E;
        Map<String, List<Node>> adj;

        public Graph(int V) {
            this.V = V;
            this.E = 0;
            adj = new HashMap<>();
        }

        public void addEdge(String name, int val, int weight){
            this.E++;
            adj.putIfAbsent(name, new ArrayList<>());
            adj.get(name).add(new Node(val, weight));
        }

    }
}
