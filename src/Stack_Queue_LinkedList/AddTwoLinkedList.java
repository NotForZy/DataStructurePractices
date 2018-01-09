package Stack_Queue_LinkedList;

/*
 * Add two Linked List,
 * each element is considered as an unit.
 */

public class AddTwoLinkedList {
    public AddTwoLinkedList() {
        test();
    }

    private ListNode addLinkedList(ListNode head1, ListNode head2) {
        ListNode newHead1 = ReverseLinkedList.reverseList(head1);
        ListNode newHead2 = ReverseLinkedList.reverseList(head2);
        int carry = 0;

        ListNode dummy = new ListNode(0);
        ListNode preNode = dummy;

        while (newHead1 != null || newHead2 != null) {
            int res = carry;
            if (newHead1 != null) {
                res += newHead1.value;
                newHead1 = newHead1.next;
            }
            if (newHead2 != null) {
                res += newHead2.value;
                newHead2 = newHead2.next;
            }

            // create new node
            ListNode n = new ListNode(res % 10);
            carry = res / 10;
            preNode.next = n;
            preNode = preNode.next;
        }

        if (carry >= 1) {
            preNode.next = new ListNode(carry);
        }

        return ReverseLinkedList.reverseList(dummy.next);
    }

    private void test() {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);
        head1.next.next.next = new ListNode(7);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);

        new ReverseLinkedList2(true).printLinkedList(head1);
        System.out.println();
        new ReverseLinkedList2(true).printLinkedList(head2);
        System.out.println();
        new ReverseLinkedList2(true).printLinkedList(addLinkedList(head1, head2));
    }
}
