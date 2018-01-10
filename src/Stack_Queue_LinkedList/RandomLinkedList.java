package Stack_Queue_LinkedList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


/*
 * Copy Random Linked List.
 */

public class RandomLinkedList {
    public RandomLinkedList() {
        test();
    }

    // Method 1: use HashMap
    private RandomNode copyRandomList(RandomNode head) {
        HashMap<RandomNode, RandomNode> map = new HashMap<>();
        RandomNode cur = head;
        while (cur != null) {
            if (!map.containsKey(cur)) {
                RandomNode curClone = new RandomNode(cur.value);
                map.put(cur, curClone);
            }
            if (cur.next != null && !map.containsKey(cur.next)) {
                RandomNode curNext = new RandomNode(cur.next.value);
                map.put(cur.next, curNext);
            }
            if (cur.random != null && !map.containsKey(cur.random)) {
                RandomNode curRandom = new RandomNode(cur.random.value);
                map.put(cur.random, curRandom);
            }
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    // Method 2: change the structure of the Random List
    //     Original -> Clone -> Original -> Clone ...
    private RandomNode copyRandomList_(RandomNode head) {
        RandomNode dummy = head;

        while (dummy != null) {
            RandomNode nextNode = dummy.next;
            RandomNode cloneNode = new RandomNode(dummy.value);
            dummy.next = cloneNode;
            cloneNode.next = nextNode;
            dummy = nextNode;
        }
        dummy = head;
        while (dummy != null && dummy.next != null) {
            dummy.next.random = dummy.random.next;
            dummy = dummy.next.next;
        }
        dummy = head;
        RandomNode newDummyHead = new RandomNode(0);
        RandomNode newDummy = newDummyHead;
        while (dummy != null) {
            newDummy.next = dummy.next;
            dummy = dummy.next.next;
            newDummy = newDummy.next;
        }
        return newDummyHead.next;

    }


    public static void printRandomList(RandomNode head) {
        RandomNode dummy = head;
        while(dummy != null) {
            System.out.print(dummy.value + " ");
            dummy = dummy.next;
        }
        System.out.println();
        dummy = head;
        while(dummy != null) {
            System.out.print(dummy.random.value + " ");
            dummy = dummy.next;
        }
    }

    private void test() {
        RandomNode head = new RandomNode(0);
        RandomNode dummy = head;
        List<RandomNode> nodeList = new LinkedList<>();
        nodeList.add(head);
        for (int i = 1; i < 10; i++) {
            RandomNode cur = new RandomNode(i);
            nodeList.add(cur);
            dummy.next = cur;
            dummy = dummy.next;
        }
        dummy = head;
        for (int i = 0; i < 10; i++) {
            dummy.random = nodeList.get((i + 5) % 10);
            dummy = dummy.next;
        }

        printRandomList(head);
        System.out.println();
        System.out.println();
        printRandomList(copyRandomList(head));
        System.out.println();
        System.out.println();
        printRandomList(head);
        System.out.println();
        System.out.println();
        printRandomList(copyRandomList_(head));
    }
}

class RandomNode {
    int value;
    RandomNode next;
    RandomNode random;
    public RandomNode(int value) {
        this.value = value;
    }
}
