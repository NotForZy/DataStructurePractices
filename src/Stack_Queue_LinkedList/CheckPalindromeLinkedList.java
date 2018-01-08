package Stack_Queue_LinkedList;

/*
 * Check if the Linked List is a palindrome.
 *
 * - Find the middle element of the palindrome.
 * - Reverse one of the two parts of Linked List.
 * - Compare the reversed the part and the normal part.
 *
 */

public class CheckPalindromeLinkedList {

    public CheckPalindromeLinkedList() {
        test();
    }

    private boolean checkPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode midHead = findMiddle(head);
        ListNode second = midHead.next;
        ListNode secondHead = ReverseLinkedList.reverseList(second);
        midHead.next = null;

        return isSame(head, secondHead);
    }

    // return the node before the middle node
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // not examine exact same;
    // List1 is always longer than List2
    private boolean isSame(ListNode head1, ListNode head2) {
        while (head2.next != null) {
            if (head1.value != head2.value) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }

    private void test() {
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        for (int i = 0; i < 5; i++) {
            ListNode cur = new ListNode(i);
            tmp.next = cur;
            tmp = tmp.next;
        }
        for (int i = 4; i > -1; i--) {
            ListNode cur = new ListNode(i);
            tmp.next = cur;
            tmp = tmp.next;
        }
        ListNode head = dummy.next;
        System.out.println("The Linked List " + (checkPalindrome(head)?"is":"is not") + " a palindrome.");
    }
}
