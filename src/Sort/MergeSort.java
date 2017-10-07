package Sort;

import java.util.LinkedList;
import java.util.List;

/**
 * @author YubaiTao on 30/08/2017.
 * @project Test
 */
public class MergeSort {
    public int[] array;
    public int size;

    public MergeSort(int[] array) {
        this.array = array;
        size = array.length;
        // result = new LinkedList<>();
    }

    public List<Integer> merge(int left, int right) {
        List<Integer> solution = new LinkedList<>();
        if (left == right) {
            solution.add(array[left]);
            return solution;
        }
        int mid = left + (right - left) / 2;
        List<Integer> solu_left = merge(left, mid);
        List<Integer> solu_right = merge(mid + 1, right);
        solution = combine(solu_left, solu_right);

        return solution;
    }


    public List<Integer> combine(List<Integer> a, List<Integer> b) {
        List<Integer> list = new LinkedList<>();
        int i = 0,j = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i) < b.get(j) ){
                list.add(a.get(i));
                i++;
            } else {
                list.add(b.get(j));
                j++;
            }
        }

        if (i == a.size()) {
            if (j == b.size()) {
                return list;
            } else {
                for (;j < b.size(); j++) {
                    list.add(b.get(j));
                }
                return list;
            }

        }

        if (j == b.size()) {
            for (; i < a.size(); i++) {
                list.add(a.get(i));
            }
        }

        return list;
    }

    public void display() {
        List<Integer> solution;
        solution = this.merge(0, size - 1);
        System.out.println("The Sorted Array(Merge Sort)");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + solution.get(i));
        }
    }
}
