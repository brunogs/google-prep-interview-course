package lesson6_1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRighSideView {

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

    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        List<Integer> out = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Deque<Integer> stack = new LinkedList<>();
            int rowSize = queue.size();
            while (rowSize > 0) {
                TreeNode current = queue.poll();
                stack.push(current.val);

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
                rowSize--;
            }
            out.add(stack.pop());
        }

        return out;
    }
}
