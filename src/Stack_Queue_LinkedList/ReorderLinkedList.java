package Stack_Queue_LinkedList;

import Stack_Queue_LinkedList.ListNode;

/**
 * project: Test
 *
 * @author YubaiTao on 07/10/2017.
 *
 * Reorder the given singly-linked list N1->N2->N3->...->Nn->null to be
 *                                      N1->Nn->N2->Nn-1->N3->Nn-2->...->null
 *
 * It's actually three sub problems:
 *     1. find middle node in sorted linked list
 *     2. reverse second part of the linked list
 *     3. merge two linked lists
 *
 */
public class ReorderLinkedList {
    public ReorderLinkedList() {

    }

    private ListNode reorder(ListNode head) {
        return head;
    }

    private void test() {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i < 20; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode result = reorder(head);
        while(result != null) {
            System.out.print(" " + result.value);
        }
    }

}
