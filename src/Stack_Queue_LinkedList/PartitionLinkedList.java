package Stack_Queue_LinkedList;

/**
 * project: Test
 *
 * @author YubaiTao on 07/10/2017.
 *
 *
 * Given a linked list and a target value T,
 * partition it such that all nodes less than T are listed before the nodes larger than or equal to target value T.
 * The original relative order of the nodes in each of the two partitions should be preserved.
 *
 */
public class PartitionLinkedList {
    public PartitionLinkedList() {
        test();
    }

    private ListNode partition(ListNode head, int target) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode smallDummyHead = new ListNode(0);
        ListNode largeDummyHead = new ListNode(0);
        ListNode equalDummyHead = new ListNode(0);
        ListNode dummyHead = new ListNode(0);
        ListNode smallCur = smallDummyHead;
        ListNode largeCur = largeDummyHead;
        ListNode equalCur = equalDummyHead;
        ListNode smallTail = null;
        ListNode midTail = null;
        ListNode cur = head;

        while (cur != null) {
            if (cur.value == target) {
                equalCur.next = cur;
                cur = cur.next;
                equalCur = equalCur.next;
                equalCur.next = null;
                midTail = equalCur;
            } else if (cur.value < target) {
                smallCur.next = cur;
                cur = cur.next;
                smallCur = smallCur.next;
                smallCur.next = null;
                smallTail = smallCur;
            } else {
                largeCur.next = cur;
                cur = cur.next;
                largeCur = largeCur.next;
                largeCur.next = null;
            }
        }

        cur = dummyHead;
        if (smallTail != null) {
            cur.next = smallDummyHead.next;
            cur = smallTail;
        }
        if (midTail != null) {
            cur.next = equalDummyHead.next;
            cur = midTail;
        }
        if (largeDummyHead.next != null) {
            cur.next = largeDummyHead.next;
        }

        return dummyHead.next;
    }

    private void test() {
        ListNode head = new ListNode(12);
        ListNode cur = head;
        for (int i = 1; i < 20; i++) {
            int r = (int)(Math.random()*20 + 1);
            ListNode newNode = new ListNode(r);
            cur.next = newNode;
            cur = cur.next;
        }
        cur = head;
        while(cur!=null) {
            System.out.print(" " + cur.value);
            cur = cur.next;
        }
        System.out.println();
        cur = partition(head, 11);
        System.out.println("The partitioned result:");
        while(cur != null) {
            System.out.print(" " + cur.value);
            cur = cur.next;
        }
    }

}
