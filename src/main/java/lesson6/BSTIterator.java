package lesson6;

import java.util.LinkedList;
import java.util.Queue;

public class BSTIterator {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class BSTIteratorQueue {

        private Queue<Integer> queue;

        public BSTIteratorQueue(TreeNode root) {
            queue = new LinkedList<>();
            fill(root, queue);
        }

        public int next() {
            return queue.poll();
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }

        public void fill(TreeNode root, Queue<Integer> queue) {
            if (root == null) {
                return;
            }
            fill(root.left, queue);
            queue.add(root.val);
            fill(root.right, queue);
        }
    }


}
