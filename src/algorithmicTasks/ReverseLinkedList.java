package algorithmicTasks;

//Given the head of a singly linked list, reverse the list, and return the reversed list.

public class ReverseLinkedList {
 public ListNode reverseList(ListNode head) {
  ListNode prev = null;
  ListNode current = head;

  while(current != null) {
   ListNode next = current.next;
   current.next = prev;
   prev = current;
   current = next;
  }
  return prev;
 }
}
