package misc.tree;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        var result = new ArrayList<Integer>();
        branchSums(root, result, 0);
        return result;
    }

    public static void branchSums(BinaryTree root, List<Integer> partial, Integer current) {
        current += root.value;
        if (root.left != null) {
            branchSums(root.left, partial, current);
        }
        if (root.right != null) {
            branchSums(root.right, partial, current);
        }
        if (root.left == null && root.right == null) {
            partial.add(current);
        }
    }

}
