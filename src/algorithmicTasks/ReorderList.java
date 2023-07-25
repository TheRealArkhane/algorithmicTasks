package algorithmicTasks;

//You are given the head of a singly linked-list. The list can be represented as:
//
//        L0 ? L1 ? … ? Ln - 1 ? Ln
//        Reorder the list to be on the following form:
//
//        L0 ? Ln ? L1 ? Ln - 1 ? L2 ? Ln - 2 ? …
//        You may not modify the values in the list's nodes. Only nodes themselves may be changed.

//Example 2:
//Input: head = [1,2,3,4,5]
//        Output: [1,5,2,4,3]

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode current = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        while (prev != null) {
            ListNode left = head.next;
            ListNode right = prev.next;
            head.next = prev;
            prev.next = left;
            prev = right;
            head = left;
        }
    }
}
