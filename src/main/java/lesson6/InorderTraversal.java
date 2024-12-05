package lesson6;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    public static void main(String[] args) {
        //TODO example
    }

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

    public List<Integer> inorderTraversal(TreeNode root) {
        var out = new ArrayList<Integer>();
        inorderTraversal(root, out);
        return out;
    }

    public void inorderTraversal(TreeNode root, List<Integer> out) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, out);
        out.add(root.val);
        inorderTraversal(root.right, out);
    }
}
