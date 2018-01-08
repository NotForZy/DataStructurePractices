package Stack_Queue_LinkedList;

/*
 * Reverse Linked List by group with size n.
 *
 * Time complexity: O(n); n = length of the linked list
 */

public class ReverseLinkedListN {

    public ReverseLinkedListN() {
        test();
    }

    private ListNode reverseInGroup(ListNode head, int n) {
        if (n == 1) {
            return head;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode preNode = dummyNode;
        ListNode curNode = head;

        int t = n; // counter
        while (curNode != null) {
            if (t == 1) {
                ListNode segHead = preNode.next;
                ListNode segTail = curNode.next;

                preNode.next = null;
                curNode.next = null;
                // reverse the group of node
                ListNode newHead = ReverseLinkedList.reverseList(segHead);
                preNode.next = newHead;
                segHead.next = segTail;

                //move reference
                preNode = segHead; // reversed version, actually tail now
                curNode = segTail; // first element of next segment
                t = n; // reset
            } else {
                t--;
                curNode = curNode.next;
            }

        }
        return dummyNode.next;
    }

    private void test() {
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        for (int i = 1; i < 9; i++) {
            ListNode cur = new ListNode(i);
            dummy.next = cur;
            dummy = dummy.next;
        }
        new ReverseLinkedList2(true).printLinkedList(head);
        System.out.println();
        new ReverseLinkedList2(true).printLinkedList(reverseInGroup(head, 3));
    }
}
