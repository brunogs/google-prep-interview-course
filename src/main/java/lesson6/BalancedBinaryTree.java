package lesson6;

public class BalancedBinaryTree {

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
        /*TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        */

        TreeNode root = new TreeNode(1);
        TreeNode firstLeft = new TreeNode(2);
        root.left = firstLeft;
        root.right = new TreeNode(2);

        firstLeft.right = new TreeNode(3);
        firstLeft.left = new TreeNode(3);
        firstLeft.left.left = new TreeNode(4);
        firstLeft.left.right = new TreeNode(4);

        var result = isBalanced(root);

        System.out.println(result);

    }

    public static boolean isBalanced(TreeNode root) {
        int result = isBalanced(root, 1);
        if (result < 0) {
            return false;
        }
        return true;
    }

    public static int isBalanced(TreeNode root, int level) {
        if (root == null) {
            return level;
        }
        int leftLevel = isBalanced(root.left, level+1);
        if (leftLevel < 0) {
            return -1;
        }
        int rightLevel = isBalanced(root.right, level+1);
        if (rightLevel < 0) {
            return -1;
        }

        if (Math.abs(leftLevel - rightLevel) >= 2) {
            return -1;
        }
        return Math.max(leftLevel, rightLevel);
    }
}
