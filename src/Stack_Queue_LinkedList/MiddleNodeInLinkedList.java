package Stack_Queue_LinkedList;

/**
 * project: Test
 *
 * @author YubaiTao on 07/10/2017.
 */
public class MiddleNodeInLinkedList {
    public MiddleNodeInLinkedList() {
        test();
    }

    public ListNode findMiddle(ListNode head) {
        ListNode fast, slow;
        fast = head;
        slow = head;
        if (head == null) {
            return null;
        }
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private void test() {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i < 10; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode result = findMiddle(head);
        System.out.println("The middle value is: " + result.value);
    }
}
