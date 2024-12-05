package lesson6;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {

    static class TreeNode {
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

    public static void main(String[] args) {
        //TODO example
    }

    public static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = root.val;

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();
            if (current == null) {
                continue;
            }
            result = current.val;

            queue.add(current.right);
            queue.add(current.left);
        }
        return result;
    }
}
