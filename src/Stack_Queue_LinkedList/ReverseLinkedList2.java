package Stack_Queue_LinkedList;


/*
 * Reverse Linked List by 2 elements.
 *
 * Example:
 *   input: 1 -> 2 -> 3 -> 4
 *   output: 2 -> 1 -> 4 -> 3
 */

public class ReverseLinkedList2 {
    public ReverseLinkedList2() {
        test();
    }

    public ReverseLinkedList2(boolean flag){

    }


    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(0);
        ListNode prevNode = dummyNode;
        ListNode curNode = head;
        ListNode nextNode = null;
        ListNode nextnextNode = null;

        while (curNode != null && curNode.next != null) {
            nextNode = curNode.next;
            nextnextNode = nextNode.next;

            nextNode.next = curNode;
            curNode.next = nextnextNode;
            prevNode.next = nextNode;

            prevNode = curNode;
            curNode = nextnextNode;
        }
        // return the head of the Linked List.
        return dummyNode.next;
    }

    private void test() {
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        for (int i = 1; i < 10; i++) {
            ListNode cur = new ListNode(i);
            dummy.next = cur;
            dummy = dummy.next;
        }

        printLinkedList(reverse(head));

    }

    public void printLinkedList(ListNode head) {
        if (head == null) {
            System.out.println("No node element.");
        }
        while(head != null) {
            System.out.print(head.value + "  ");
            head = head.next;
        }
    }
}
