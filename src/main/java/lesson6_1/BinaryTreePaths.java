package lesson6_1;

import lesson6.ValidateBST;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

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

    public List<String> binaryTreePaths(TreeNode root) {
        var result = new ArrayList<String>();
        binaryTreePaths(root, "", result);
        return result;
    }

    public void binaryTreePaths(TreeNode root, String partial, List<String> result) {
        if (root.left == null && root.right == null) {
            partial += root.val;
            result.add(partial);
            return;
        } else {
            partial += root.val + "->";
        }

        if (root.left != null) {
            binaryTreePaths(root.left, partial, result);
        }
        if (root.right != null) {
            binaryTreePaths(root.right, partial, result);
        }
    }
}
