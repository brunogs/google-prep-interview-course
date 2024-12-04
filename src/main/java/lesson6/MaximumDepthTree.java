package lesson6;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthTree {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public static void main(String[] args) {
        //TODO add example here
    }

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int max = 0;

        while(!queue.isEmpty()) {
            max++;
            int size = queue.size();
            while (size > 0) {
                Node current = queue.poll();

                for (Node ch : current.children) {
                    queue.add(ch);
                }
                size--;
            }
        }

        return max;
    }

}
