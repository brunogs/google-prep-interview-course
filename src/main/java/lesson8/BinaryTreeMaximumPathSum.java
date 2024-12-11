package lesson8;

public class BinaryTreeMaximumPathSum {

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

    static class Soma {
        public Soma(Integer total) { this.total = total; }
        Integer total;
    }

    public static void main(String[] args) {
        //TODO example here
    }

    static public int maxPathSum(TreeNode root) {
        var soma = new Soma(Integer.MIN_VALUE);

        maxPathSum(root, soma);

        return soma.total;
    }

    static public int maxPathSum(TreeNode node, Soma soma) {
        if (node == null) {
            return 0;
        }

        int leftSum = Math.max(maxPathSum(node.left, soma), 0);
        int rightSum = Math.max(maxPathSum(node.right, soma), 0);

        int sumNodes = leftSum + rightSum + node.val;

        soma.total = Math.max(sumNodes, soma.total);

        return node.val + Math.max(leftSum, rightSum);
    }
}
