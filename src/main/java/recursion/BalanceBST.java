package recursion;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST {

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
        /*
        1
          \
            2
              \
                3
                  \
                     4
         */
        var root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));
        var result = balanceBST(root);
        System.out.println(result);
    }

    public static TreeNode balanceBST(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        System.out.println(list);

        //int middle = list.size() / 2;
        int start = 0;
        int end = list.size() - 1;

        return buildBST(list, start, end);
    }

    private static TreeNode buildBST(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildBST(list, start, mid - 1);
        root.right = buildBST(list, mid + 1, end);
        return root;
    }

    public static void inOrder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inOrder(node.left, result);
        result.add(node.val);
        inOrder(node.right, result);
    }
}
