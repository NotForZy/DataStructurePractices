package Stack_Queue_LinkedList;

public class CheckLinkedListCircle {

    public CheckLinkedListCircle() {
        test();
    }

    private boolean hasCircle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // put in here because at the beginning,
            // fast == slow already.
            if (fast == slow) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                System.out.println("The entrance has value " + slow.value);
                return true;
            }
        }
        return false;
    }

    /*
     * How to find the entrance of the circle?
     *
     *
     *                                 []
     *                                /  \
     *                               []  [] ------>>>>> K
     *                               \  /
     * [] -> [] -> [] -> [] -> [] -> []
     * |<----------- X -------------->|
     *
     * X : The element number before enter the circle.
     * Y : The element number in the circle.
     * K : Slow pointer and the fast pointer meet at Kth element in the circle.
     *
     *
     * slow pointer: t = X + nY + K          (1)
     * fast pointer: 2t = X + mY + K         (2)
     *
     * with (1) and (2):
     *     X + K = (m - 2n)Y
     *
     * So just tune the stride of both slow and fast pointer to 1,
     * slow(or fast) start at head, fast start at K,
     *                                          (K + X) = (m-2n)Y
     * they will finally meet at the entrance of the circle.
     *
     */

    private void test() {
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        for (int i = 1; i < 10; i++) {
            ListNode cur = new ListNode(i);
            dummy.next = cur;
            dummy = dummy.next;
            if (i == 9) {
                cur.next = head.next.next;
            }
        }
        System.out.println("The Linked List " + (hasCircle(head)?"has":"do not have") + " a circle.");
    }
}
