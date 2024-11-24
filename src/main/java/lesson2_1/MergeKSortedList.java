package lesson2_1;

import java.util.PriorityQueue;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 */
public class MergeKSortedList {

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));

        ListNode result = mergeKLists(lists);
        System.out.println(result);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(val);
            ListNode cur = next;
            while (cur != null) {
                sb.append(cur.val).append("->");
                cur = cur.next;
            }
            return sb.toString();
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        boolean hasElements = true;
        while (hasElements) {
            boolean listsEmpty = true;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    listsEmpty = false;
                    heap.add(lists[i].val);
                    lists[i] = lists[i].next;
                }
            }
            if (listsEmpty) {
                hasElements = false;
            }
        }

        if (heap.isEmpty()) {
            return null;
        }

        ListNode head = new ListNode(heap.poll());
        ListNode current = head;
        while (!heap.isEmpty()) {
            int element = heap.poll();
            current.next = new ListNode(element);
            current = current.next;
        }

        return head;
    }
}
