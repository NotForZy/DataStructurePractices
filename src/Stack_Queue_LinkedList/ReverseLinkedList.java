package Stack_Queue_LinkedList;

/**
 * @author YubaiTao on 03/09/2017.
 * @project Test
 *
 * Reverse a singly-linked list
 *
 */
public class ReverseLinkedList {
    public ReverseLinkedList() {
        test();
    }

    // Iterative method
    public ListNode reverseList(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode next = null;
        ListNode curNode = head;

        // do not care cur.next.next in the loop
        // cur.next.next is implemented by "cur.next = prev" in the next loop
        while (curNode != null) {
            next = curNode.next;
            curNode.next = prev;
            prev = curNode;
            curNode = next;
        }

        return prev;
    }

    // Recursion method
    public ListNode reverseList_(ListNode head) {
        /*
        if (head == null || head.next == null) {
            return head;
        }
        */
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        ListNode newHead = reverseList_(head.next);
        nextNode.next = head;
        head.next = null;

        return newHead;
    }

    public void test() {
        int i = 1;
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(i < 10) {
            p.next = new ListNode(i);
            i++;
            p = p.next;
        }
        p = head;
        System.out.println("Original List:");
        while(p != null) {
            System.out.print(" " + p.value);
            p = p.next;
        }

        head = reverseList(head);
        p = head;
        System.out.println("\nReversed List(Iterative):");
        while(p != null) {
            System.out.print(" " + p.value);
            p = p.next;
        }

        head = reverseList_(head);
        p = head;
        System.out.println("\nReversed List(Recursive):");
        while(p != null) {
            System.out.print(" " + p.value);
            p = p.next;
        }
    }
}


// node in list
class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
        next = null;
    }
}