package Stack_Queue_LinkedList;

import java.util.LinkedList;
import java.util.List;

/**
 * project: Test
 *
 * @author YubaiTao on 03/10/2017.
 */
public class StackImplementation {
    List<Integer> stack = new LinkedList<>();
    public StackImplementation() {
        test();
    }

    public int pop() {
        if (stack.size() == 0) {
            return -1;
        }
        int result = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);

        return result;
    }

    public void push(int element) {
        stack.add(element);
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.get(stack.size() - 1);
    }

    public int min() {
        if (stack.size() == 0) {
            return -1;
        }
        int minValue = stack.get(0);
        for (int i = 0; i < stack.size(); i++) {
            if (minValue > stack.get(i)) {
                minValue = stack.get(i);
            }
        }
        return minValue;
    }

    private void printStack() {
        if (stack.isEmpty()) {
            System.out.println("Empty stack!");
            return;
        }
        for (int i = 0; i < stack.size(); i++) {
            System.out.print(" " + stack.get(i));
        }
        System.out.println();
        return;
    }

    private void test() {
        this.push(6);
        this.push(8);
        this.pop();
        this.push(5);
        this.push(9);
        this.push(9);
        System.out.println("min: " + this.min());
        this.printStack();
    }
}
