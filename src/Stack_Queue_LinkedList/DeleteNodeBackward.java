package Stack_Queue_LinkedList;


/*
 * Delete the last n-th node in Linked List.
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 *
 */

public class DeleteNodeBackward {

    public DeleteNodeBackward() {
        test();
    }

    private ListNode delete(ListNode head, int n) {
        // use dummy node(head) here
        // because the first node can be deleted
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        // Not 'n > 0'
        // n means strides, so 0 stride => 1st element
        // n-th element = n - 1 stride
        while(n > 1) {
            fast = fast.next;
            n--;
        }

        while(fast.next.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // delete the node in the Linked List
        ListNode newNextNode = slow.next.next;
        slow.next.next = null;
        slow.next = newNextNode;

        return dummy.next;
    }

    private void test() {
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        for (int i = 1; i < 10; i++) {
            ListNode cur = new ListNode(i);
            dummy.next = cur;
            dummy = dummy.next;
        }
        new ReverseLinkedList2(true).printLinkedList(head);
        System.out.println();
        new ReverseLinkedList2(true).printLinkedList(delete(head, 5));
    }
}
