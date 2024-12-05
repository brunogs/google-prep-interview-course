package lesson6_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {

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
        //TODO
    }

    public static List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int rowSize = queue.size();
            int greater = Integer.MIN_VALUE;

            while (rowSize > 0) {
                TreeNode current = queue.poll();
                greater = Math.max(greater, current.val);
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
                rowSize--;
            }

            result.add(greater);
        }

        return result;
    }
}
