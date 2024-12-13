package lesson9;

public class IntersectionOfTwoLinkedLists {

    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        var current = headA;
        ListNode last = null;
        while (current != null) {
            if (current.next == null) {
                last = current;
                last.next = headA;
                break;
            }
            current = current.next;
        }

        var fast = headB;
        var slow = headB;

        do {
            fast = fast.next;
            if (fast == null) {
                last.next = null;
                return null;
            }
            fast = fast.next;
            if (fast == null) {
                last.next = null;
                return null;
            }
            slow = slow.next;
        } while (fast != slow);

        fast = headB;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        last.next = null;
        return slow;
    }
}
