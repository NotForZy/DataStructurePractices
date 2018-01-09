package Stack_Queue_LinkedList;

/*
 * Check if there is an intersect point
 * between two Linked List.
 */

public class CheckLinkedListIntersection {
    public CheckLinkedListIntersection() {
        test();
    }

    private boolean checkIntersection(ListNode head1, ListNode head2) {
        ListNode dummy1 = head1;
        ListNode dummy2 = head2;
        while (dummy1.next != null) {
            dummy1 = dummy1.next;
        }
        while (dummy2.next != null) {
            dummy2 = dummy2.next;
        }
        return dummy1 == dummy2;
    }

    /*
     * If two Linked List are intersect with each other,
     * get the intersect node.
     *
     * - Compute the length of each Linked List
     * - Compute the difference of two Linked List length
     * - Move forward the longer Linked List with diff steps
     * - Simultaneously scan two Linked List, till same node shows up
     *
     * Time complexity: O(m + n)
     *
     */
    private ListNode getIntersectNode(ListNode head1, ListNode head2) {
        ListNode dummy1 = head1;
        ListNode dummy2 = head2;
        int counter1 = 0;
        int counter2 = 0;
        while (dummy1 != null) {
            counter1++;
            dummy1 = dummy1.next;
        }
        while (dummy2 != null) {
            counter2++;
            dummy2 = dummy2.next;
        }
        int diff = counter1 - counter2;
        dummy1 = head1;
        dummy2 = head2;
        if (diff >= 0) {
            while(diff > 0) {
                dummy1 = dummy1.next;
                diff--;
            }
        } else {
            while(diff < 0) {
                dummy2 = dummy2.next;
                diff++;
            }
        }
        while (dummy1 != dummy2) {
            dummy1 = dummy1.next;
            dummy2 = dummy2.next;
        }

        return dummy1;
    }

    /*
     * What if compute K Linked List intersect node?
     *
     *  Method 1:
     *      - Find the length of K Linked List respectively
     *      - Find the difference between K - 1 Linked Lists with the shortest Linked List
     *      - Move diff steps for K - 1 non-shortest Linked Lists
     *      - Scan them simultaneously, till find the intersect node
     *      O(2kn(avg))
     *
     *  Method 2:
     *      - Pick one Linked List, build a HashMap; key -> value : node -> occurrence times
     *      - Traverse all other Linked Lists, if node shows up, +1 in the HashMap
     *      - When traverse the k-th Linked List, judge whether there is a k - 1 entrance.
     *      Time Complexity: O(nk)
     */

    private void test() {
        ListNode head1 = new ListNode(0);
        ListNode dummy1 = head1;
        ListNode head2 = new ListNode(0);
        ListNode dummy2 = head2;

        for (int i = 1; i < 5; i++) {
            ListNode cur = new ListNode(i);
            dummy1.next = cur;
            dummy1 = dummy1.next;
        }
        for (int i = 1; i < 10; i++) {
            ListNode cur = new ListNode(i);
            dummy2.next = cur;
            dummy2 = dummy2.next;
            if (i == 7) {
                dummy1.next = dummy2;
            }
        }

        new ReverseLinkedList2(true).printLinkedList(head1);
        System.out.println();
        new ReverseLinkedList2(true).printLinkedList(head2);
        System.out.println();
        System.out.println("These two Linked List " + (checkIntersection(head1, head2)?"intersects.":"do not intersect"));
        int intersectValue = getIntersectNode(head1, head2).value;
        System.out.println("The intersect node has value: " + intersectValue);
    }
}
