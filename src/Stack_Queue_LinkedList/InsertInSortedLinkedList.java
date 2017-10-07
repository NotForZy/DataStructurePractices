package Stack_Queue_LinkedList;

import Stack_Queue_LinkedList.ListNode;

/**
 * project: Test
 *
 * @author YubaiTao on 07/10/2017.
 *
 *
 * Insert a value in the sorted linked list.
 *
 * STANDARD ANSWER, NOT ORIGINAL
 *
 */
public class InsertInSortedLinkedList {
    public InsertInSortedLinkedList() {
        test();
    }

    private ListNode insert(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        // 1. determine if the inserted node is before head.
        if (head == null || head.value >= value) {
            newNode.next = head;
            return newNode;
        }
        // 2. insert the new node to the right position.
        // using the previous node to traverse the linked list
        // the insert position of the new node should be between prev and
        // prev.next
        ListNode prev = head;
        while (prev.next != null && prev.next.value < value) {
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;

        return head;

        // original answer:
        /*
        Stack_Queue_LinkedList.ListNode cur = head;
        Stack_Queue_LinkedList.ListNode insertNode = new Stack_Queue_LinkedList.ListNode(value);
        if (head == null) {
            return insertNode;
        }
        if (cur.next == null) {
            if (cur.value < value) {
                cur.next = insertNode;
                return cur;
            } else {
                insertNode.next = cur;
                return insertNode;
            }
        }
        if (head.value > value) {
            insertNode.next = head;
            return insertNode;
        }
        while(cur != null) {
            if (cur.value <= value && cur.next == null) {
                cur.next = insertNode;
                return head;
            }
            if(cur.value <= value && cur.next.value >= value) {
                insertNode.next = cur.next;
                cur.next = insertNode;
                return head;
            }
            cur = cur.next;
        }
        return head;
        */
    }

    private void test() {
        return;
    }
}



