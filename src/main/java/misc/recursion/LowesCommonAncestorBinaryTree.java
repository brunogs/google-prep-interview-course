package misc.recursion;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LowesCommonAncestorBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    record Pair(TreeNode node, List<TreeNode> parents){}

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> parents = findParents(root, p, new ArrayList<>());

        for (int i = parents.size()-1; i >= 0; i--) {
            var current = parents.get(i);
            if (isParentOf(current, q)) {
                return current;
            }
        }
        return null;
    }

    private boolean isParentOf(TreeNode root, TreeNode item) {
        if (root == null)
            return false;
        if (root.val == item.val)
            return true;
        return isParentOf(root.left, item) || isParentOf(root.right, item);
    }


    private List<TreeNode> findParents(TreeNode root, TreeNode item, List<TreeNode> parents) {
        Deque<Pair> stack = new LinkedList<>();
        stack.push(new Pair(root, new ArrayList<>()));

        while (!stack.isEmpty()) {
            var current = stack.pop();

            List<TreeNode> newParents = new ArrayList<>(current.parents());
            newParents.add(current.node());

            var currentNode = current.node();

            if (currentNode.val == item.val)
                return newParents;
            if (currentNode.left != null)
                stack.push(new Pair(currentNode.left, newParents));
            if (currentNode.right != null)
                stack.push(new Pair(currentNode.right, newParents));
        }

        // never reach this
        return null;
    }
}
