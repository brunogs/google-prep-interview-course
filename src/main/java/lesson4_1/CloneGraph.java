package lesson4_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main(String[] args) {
        // [[2,4],[1,3],[2,4],[1,3]]


        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.neighbors.add(n2);
        n1.neighbors.add(n4);

        n2.neighbors.add(n1);
        n2.neighbors.add(n3);

        n3.neighbors.add(n2);
        n3.neighbors.add(n4);

        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        Node node = cloneGraph(n1);

        System.out.println(node);

    }

    public static Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        //1[2,4, 2[1,3], 3[2,4], 4[1,3]]

        Set<String> visited = new HashSet<>();
        Set<String> parentMapping = new HashSet<>();
        PriorityQueue<Node> heap = new PriorityQueue<>(Comparator.comparingInt(i -> i.val));

        Map<Integer, List<Node>> parents = new HashMap<>();
        Map<Integer, Node> valToCopy = new HashMap<>();

        heap.add(node); //
        //visited.add(node.val); //
        Node copyHead = new Node(node.val); //
        valToCopy.put(copyHead.val, copyHead);
        Node copyCurrent = copyHead;

        while (!heap.isEmpty()) {

            Node next = heap.poll();  //2[1,3]

            if (next.val != copyCurrent.val) {

                Node copy = valToCopy.getOrDefault(next.val, new Node(next.val));
                valToCopy.put(next.val, copy);
                copyCurrent = copy;

                for (Node parentNode : parents.get(copyCurrent.val)) {
                    var pair = parentNode.val + "_" + copyCurrent.val;
                    if (!parentMapping.contains(pair)) {
                        parentNode.neighbors.add(copyCurrent);
                        parentMapping.add(pair);
                    }
                }
            }
            System.out.println("current" + copyCurrent.val);

            for (Node neigh : next.neighbors) { //
                var pair = copyCurrent.val + "_" + neigh.val;
                if (visited.contains(pair)) { //
                    continue;
                }
                visited.add(pair); //
                heap.add(neigh); // 4[1,3]

                List<Node> nodeParents = parents.get(neigh.val);
                if (nodeParents == null) {
                    nodeParents = new ArrayList<>();
                }
                nodeParents.add(copyCurrent);
                parents.put(neigh.val, nodeParents); //
            }
        }

        System.out.println(parents);
        System.out.println(visited);

        Queue<Node> q = new LinkedList<>();
        Set<String> copyVisited = new HashSet<>();
        q.add(copyHead);

        while (!q.isEmpty()) {
            Node current = q.poll();

            for (Node neigh : current.neighbors) {
                var pair = current.val + "_" + neigh.val;
                if (copyVisited.contains(pair)) {
                    continue;
                }
                System.out.println(current.val + " (" + neigh.val + ")");
                copyVisited.add(pair);
                q.add(neigh);
            }
        }
        return copyHead;
    }
}
