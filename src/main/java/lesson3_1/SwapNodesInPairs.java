package lesson3_1;

/**
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 */
public class SwapNodesInPairs {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }

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
        //1,2,3,4
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        var result = swapPairs(list);

        System.out.println(result);
    }

    public static ListNode swapPairsAux(ListNode first, ListNode second) {
        if (first != null && second == null) {
            return new ListNode(first.val);
        } else if (first == null && second == null) {
            return null;
        }

        ListNode nextFirst = second.next;
        ListNode nextSecond = null;
        if (nextFirst != null) {
            nextSecond = nextFirst.next;
        }
        return new ListNode(second.val, new ListNode(first.val, swapPairsAux(nextFirst, nextSecond)));
    }

    public static ListNode swapPairs(ListNode head) {
        return swapPairsAux(head, head != null ? head.next : null);
    }


}
