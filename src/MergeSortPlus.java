/**
 * @author YubaiTao on 01/09/2017.
 * @project Test
 */
public class MergeSortPlus {
    public int[] array;
    public int size;

    public MergeSortPlus(int[] array){
        this.array = array;
        size = array.length;
    }

    public int[] sort(int[] array) {
        int[] solution = new int[array.length];
        merge(array, solution, 0, array.length - 1);

        return array;
    }

    private void merge(int[] array, int[] solution, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left)/2;
        merge(array, solution, left, mid);
        merge(array, solution, mid + 1, right);
        combine(array, solution, left, mid, right);
    }

    private void combine(int[] array, int[] solution, int left, int mid, int right) {
        for ( int i = left; i <= right; i++) {
            solution[i] = array[i];
            // array[i] = solution[i];
        }
        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= right) {
            if (solution[leftIndex] <= solution[rightIndex]) {
                array[left] = solution[leftIndex];
                left++;
                leftIndex++;
            } else {
                array[left] = solution[rightIndex];
                left++;
                rightIndex++;
            }
        }
        while(leftIndex <= mid) {
            array[left] = solution[leftIndex];
            leftIndex++;
            left++;
        }

    }



    public void display() {
        int[] solution = sort(array);
        System.out.println("The Sorted Array(MergeSortPlus):");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + solution[i]);
        }
    }



}
