package Stack_Queue_LinkedList;

/**
 * project: Test
 *
 * @author YubaiTao on 07/10/2017.
 */
public class MergeTwoSortedLinkedLists {
    public MergeTwoSortedLinkedLists () {
        test();
    }

    private ListNode merge(ListNode one, ListNode two) {
        if (one == null && two == null) {
            return null;
        }
        if (one == null) {
            return two;
        }
        if (two == null) {
            return one;
        }
        ListNode curOne, curTwo;
        curOne = one;
        curTwo = two;
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (!(curOne == null && curTwo == null)) {
            if (curTwo == null) {
                cur.next = curOne;
                curOne = curOne.next;
                cur.next.next = null;
                cur = cur.next;
                continue;
            }
            if (curOne== null) {
                cur.next = curTwo;
                curTwo = curTwo.next;
                cur.next.next = null;
                cur = cur.next;
                continue;
            }
            if (curOne.value <= curTwo.value) {
                cur.next = curOne;
                curOne = curOne.next;
                cur.next.next = null;
                cur = cur.next;
                continue;
            }
            if (curTwo.value < curOne.value) {
                cur.next = curTwo;
                curTwo = curTwo.next;
                cur.next.next = null;
                cur = cur.next;
            }
        }

        return dummyHead.next;
    }

    private void test() {
        ListNode listOne = new ListNode(0);
        ListNode listTwo = new ListNode(1);
        ListNode cur1 = listOne;
        ListNode cur2 = listTwo;
        for (int i = 2; i < 10; i += 2) {
            ListNode cur = new ListNode(i);
            cur1.next = cur;
            cur1 = cur1.next;
        }
        for (int i = 3; i < 10; i += 2) {
            ListNode cur = new ListNode(i);
            cur2.next = cur;
            cur2 = cur2.next;
        }

        ListNode result = merge(listOne, listTwo);
        while (result != null) {
            System.out.print(" " + result.value);
            result = result.next;
        }
    }
}
