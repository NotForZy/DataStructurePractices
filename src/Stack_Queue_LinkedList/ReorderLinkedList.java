package Stack_Queue_LinkedList;



/**
 * project: Test
 *
 * @author YubaiTao on 07/10/2017.
 *
 * Reorder the given singly-linked list N1->N2->N3->...->Nn->null to be
 *                                      N1->Nn->N2->Nn-1->N3->Nn-2->...->null
 *
 * It's actually three sub-problems:
 *     1. find middle node in sorted linked list
 *     2. reverse second part of the linked list
 *     3. merge two linked lists
 *
 */
public class ReorderLinkedList {
    public ReorderLinkedList() {
        test();
    }

    private ListNode reorder(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null || head.next.next == null) {
            return head;
        }
        int counter = getSize(head);
        ListNode middle = new MiddleNodeInLinkedList().findMiddle(head);
        // make sure the first part is longer than the second part.
        ListNode reversePart = new ReverseLinkedList().reverseList_(middle.next);


        ListNode firstCur = head;
        ListNode secondCur = reversePart;
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        System.out.println("\nMiddle: " + middle.value);
        System.out.println("ReversePart: " + reversePart.value);
        System.out.println("Counter: " + counter);
        while (counter > 0) {
            cur.next = firstCur;
            firstCur = firstCur.next;
            cur = cur.next;
            cur.next = null;
            counter--;

            if (counter == 0) {
                continue;
            }

            cur.next = secondCur;
            secondCur = secondCur.next;
            cur = cur.next;
            // remember to set the last element to null
            // or there can be linked list ring.
            cur.next = null;
            counter --;
        }

        return dummyHead.next;
    }

    private int getSize(ListNode head) {
        int counter = 0;
        if (head == null) {
            return 0;
        }
        ListNode cur = head;
        while (cur != null) {
            counter += 1;
            cur = cur.next;
        }
        return counter;
    }



    private void test() {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i < 4; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        int counter = getSize(head);
        ListNode result = reorder(head);
        System.out.println("\n-------------------------------");

        System.out.println("Size in test: " + counter);

        while(result != null) {
            System.out.print(" " + result.value);
            result = result.next;
            counter--;
        }
    }

}
