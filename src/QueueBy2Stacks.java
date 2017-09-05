import java.util.LinkedList;
import java.util.List;

/**
 * @author YubaiTao on 03/09/2017.
 * @project Test
 *
 * Implement a queue by using two stacks. The queue should provide size(), isEmpty()
 * push(), front() and pop() operations. When the queue is empty, front() should return -1.
 *
 * Assumptions:
 *   The elements in the queue are all Integers.
 *   size() should return the number of elements buffered in the queue.
 *   isEmpty() should return true if there is no element buffered in the queue, false otherwise.
 */
public class QueueBy2Stacks {
    private LinkedList<Integer> in;
    private LinkedList<Integer> out;

    public QueueBy2Stacks() {
        in = new LinkedList<>();
        out = new LinkedList<>();

    }

    // remove and return the head of the queue
    public Integer poll() {
        if (out.size() == 0) {
            if (in.size() == 0) {
                return null;
            }
            dump();
        }
        return out.removeLast();
    }

    // insert an element if possible
    public void offer(int element) {
        in.add(element);
    }

    // retrieves, but does not remove, the head of this queue,
    // or return null if the queue is empty.
    public Integer peek() {
        // dump();
        if (out.isEmpty()) {
            dump();
            System.out.print(" " + out.getLast());
            return out.getLast();
        } else {
            System.out.print(" " + out.getLast());
            return out.getLast();
        }
    }

    public int size() {
        return in.size() + out.size();
    }

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void dump() {
        if (in.size() == 0) {
            return;
        }
        while (!in.isEmpty()) {
            out.add(in.removeLast());
        }
//        for (int i = 0; i < in.size(); i++) {
//            int elem = in.removeLast();
//            out.add(elem);
//        }
    }
}
