package misc.tree;

public class FindClosestInBST {

    public static void main(String[] args) {
        // Manually instantiate the tree nodes
        BST head = new BST(100);
        head.left = new BST(5);
        head.right = new BST(502);

        head.right.left = new BST(204);
        head.right.right = new BST(55000);

        head.right.right.left = new BST(1001);
        head.right.right.left.right = new BST(4500);

        head.right.left.left = new BST(203);
        head.right.left.right = new BST(205);

        head.right.left.right.right = new BST(207);
        head.right.left.right.right.left = new BST(206);
        head.right.left.right.right.right = new BST(208);

        head.left.left = new BST(2);
        head.left.right = new BST(15);

        head.left.left.left = new BST(1);
        head.left.left.right = new BST(3);

        head.left.left.left.left = new BST(-51);
        head.left.left.left.right = new BST(1);
        head.left.left.left.right.right = new BST(1);
        head.left.left.left.right.right.right = new BST(1);
        head.left.left.left.right.right.right.right = new BST(1);

        head.left.left.left.left.right = new BST(-403);

        head.left.right.left = new BST(5);
        head.left.right.right = new BST(22);

        head.left.right.right.right = new BST(57);
        head.left.right.right.right.right = new BST(60);

        var result = findClosestValueInBst(head, -1);
        System.out.println(result);
    }


    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.

        Integer closer = null;

        return findClosestValueInBst(tree, target, closer);
    }

    public static int findClosestValueInBst(BST tree, int target, Integer close) {
        // Write your code here.
        if (tree == null)
            return close;
        int partial = Math.abs(tree.value - target);
        if (close == null) {
            close = tree.value;
        } else {
            close = (partial < Math.abs(close - target)) ? tree.value : close;
        }

        if (tree.value < target)
            return findClosestValueInBst(tree.right, target, close);
        else if (tree.value > target)
            return findClosestValueInBst(tree.left, target, close);
        else
            return tree.value;
    }

    private static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

}
