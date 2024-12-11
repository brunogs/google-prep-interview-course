package lesson7;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteNodeInBST {

    public class TreeNode {
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

    }

    /**
     * Solução do chatgpt
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null; // Caso base: nó não encontrado.
        }

        if (key < root.val) {
            // Procure na subárvore esquerda.
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            // Procure na subárvore direita.
            root.right = deleteNode(root.right, key);
        } else {
            // Encontramos o nó a ser deletado.
            if (root.left == null && root.right == null) {
                // Caso 1: O nó é uma folha.
                return null;
            } else if (root.left == null) {
                // Caso 2: Apenas filho direito.
                return root.right;
            } else if (root.right == null) {
                // Caso 2: Apenas filho esquerdo.
                return root.left;
            } else {
                // Caso 3: Dois filhos.
                TreeNode successor = findMin(root.right); // Encontre o menor nó na subárvore direita.
                root.val = successor.val; // Substitua o valor do nó atual pelo valor do sucessor.
                root.right = deleteNode(root.right, successor.val); // Delete o sucessor.
            }
        }

        return root;
    }

    // Encontre o menor valor em uma árvore (mais à esquerda possível).
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * Minha solução incorreta
     */

    /*public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode head = root;
        if (head == null) {
            return null;
        }
        TreeNode[] target = findTarget(root, key);
        if (target == null) {
            return head;
        }
        System.out.println("target found " + target[1].val);

        if (target[1].left == null && target[1].right == null) {
            if (target[0].left == null && target[0].right == null) {
                return null;
            } else if (target[0].left.val == key) {
                target[0].left = null;
            } else {
                target[0].right = null;
            }
        } else {
            TreeNode successor = findSuccessor(root, key);
            int temp = target[1].val;
            target[1].val = successor.val;
            System.out.println("successor found " + successor.val);
            successor.val = temp;
            System.out.println("successor now " + successor.val);
            deleteNode(head, key);
        }

        return head;
    }

    public TreeNode[] findTarget(TreeNode current, int target) {
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[]{current, current});

        while (!queue.isEmpty()) {
            int row = queue.size();
            TreeNode parent = null;
            while (row > 0) {
                TreeNode[] it = queue.poll();

                System.out.println("searching " + it[1].val + " for " + target);
                if (it[1].val == target) {
                    return it;
                }
                TreeNode item = it[1];
                if (item.left != null) {
                    queue.add(new TreeNode[]{item, item.left});
                }
                if (item.right != null) {
                    queue.add(new TreeNode[]{item, item.right});
                }
                row--;
            }
        }
        // nao deve chegar aqui
        return null;
    }

    public TreeNode findSuccessor(TreeNode current, int nodeVal) {
        TreeNode successor = null;
        while (current != null) {
            if (current.val > nodeVal) {
                successor = current;
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return successor;
    }*/

}
