package Stack_Queue_LinkedList;

import java.util.LinkedList;
import java.util.List;

/**
 * project: Test
 *
 * @author YubaiTao on 06/10/2017.
 *
 *  -> in || out ->
 *       head
 */
public class QueueByTwoStacks {
    public LinkedList<Integer> in;
    public LinkedList<Integer> out;
    public QueueByTwoStacks() {
        in = new LinkedList<Integer>();
        out = new LinkedList<Integer>();
    }


    private void dump() {
        while (in.size() != 0) {
            out.add(in.removeLast());
        }
    }

    // poll(): retrieves and removes the head of this queue,
    //         or return null if this queue is empty.
    public Integer poll() {
        if (out.size() == 0) {
            dump();
        }

        return out.removeLast();
    }

    // peek(): retrieves, but does not remove,
    //         the head of this queue, or returns null if this queue is empty.
    public Integer peek() {
        if (out.size() == 0) {
            if (in.size() == 0) {
                return null;
            } else {
                dump();
            }
        }
        return out.getLast();
    }

    public int size() {
        return in.size()+out.size();
    }

    public boolean isEmpty() {
        if ((in.size() == 0) && (out.size() == 0)) {
            return true;
        }
        return false;
    }
}
