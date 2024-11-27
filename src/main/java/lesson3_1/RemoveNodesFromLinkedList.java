package lesson3_1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * You are given the head of a linked list.
 *
 * Remove every node which has a node with a greater value anywhere to the right side of it.
 *
 * Return the head of the modified linked list.
 */
public class RemoveNodesFromLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(val).append("->");
            ListNode cur = next;
            while (cur != null) {
                sb.append(cur.val).append("->");
                cur = cur.next;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        var list = new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8)))));

        var result = removeNodes(list);
        System.out.println(result);
    }

    public static ListNode reduce(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode partial = reduce(head.next);
        if (head.val >= partial.val) {
            return new ListNode(head.val, partial);
        }
        return partial;
    }

    public static ListNode monotonic(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();

        ListNode current = head;
        while (current != null) {
            while (!stack.isEmpty() && stack.peek() < current.val) {
                stack.pop();
            }
            stack.push(current.val);
            current = current.next;
        }
        ListNode out = null;
        while (!stack.isEmpty()) {
            if (out == null) {
                out = new ListNode(stack.pop());
            } else {
                out = new ListNode(stack.pop(), out);
            }
        }
        return out;
    }

    public static ListNode removeNodes(ListNode head) {
        return monotonic(head);
    }
}
