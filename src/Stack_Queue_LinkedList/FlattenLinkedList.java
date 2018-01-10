package Stack_Queue_LinkedList;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * Flatten a multiple layer Linked List.
 *
 * Node:
 *    -> next
 *    |  child
 *
 *
 * Example input:
 *     1 -> 2 -> 3 -> 4 -> 5
 *     |         |
 *     6 -> 7    8
 *               |
 *               9 -> 10
 *                    |
 *                    11
 *
 * Output:
 *     1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> .. -> 11
 */

public class FlattenLinkedList {
    public FlattenLinkedList() {
        test();
    }

    // use a queue, like BFS
    private Node flatten(Node head) {
        Queue<Node> queue = new ArrayDeque<>();
        Node dummy = head;
        Node newDummyHead = new Node(0);
        Node newDummy = newDummyHead;
        queue.offer(dummy);
        while (!queue.isEmpty()) {
            dummy = queue.poll();
            while (dummy != null) {
                if (dummy.child != null) {
                    queue.offer(dummy.child);
                }
                newDummy.next = dummy;
                newDummy = newDummy.next;
                dummy = dummy.next;
            }
        }

        return newDummyHead.next;
    }

    private void test() {
        Node head = new Node(1);
        Node dummy = head;
        for (int i = 2; i < 6; i++) {
            Node cur = new Node(i);
            dummy.next = cur;
            dummy = dummy.next;
        }
        head.child = new Node(6);
        head.child.next = new Node(7);
        Node secondChild = new Node(8);
        head.next.next.child = secondChild;
        secondChild.child = new Node(9);
        secondChild.child.next = new Node(10);
        secondChild.child.next.child = new Node(11);

        Node flatHead = flatten(head);
        System.out.println("The flatten Linked List:");
        System.out.print("    ");
        while (flatHead != null) {
            System.out.print(flatHead.value + " ");
            flatHead = flatHead.next;
        }
    }

    private class Node {
        private Node (int value) {
            this.value = value;
        }
        int value;
        Node next;
        Node child;
    }
}
