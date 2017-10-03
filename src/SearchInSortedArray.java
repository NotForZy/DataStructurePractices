/**
 * project: Test
 *
 * @author YubaiTao on 03/10/2017.
 */
public class SearchInSortedArray {
    public SearchInSortedArray() {
        this.test();
    }

    private int[] binarySearch(int[][] matrix, int target) {
        int[] array = linearize(matrix);
        int left = 0;
        int right = array.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target) {
                index = mid;
                break;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }


        return delinearize(matrix, index);
    }

    private int[] linearize(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] array = new int[row*col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                array[i*col + j] = matrix[i][j];
            }
        }

        return array;
    }

    private int[] delinearize(int[][] matrix, int index) {
        if (index == -1) {
            return new int[] {-1, -1};
        }
        int[] result = new int[2];
        // int row = matrix.length;
        int col = matrix[0].length;
        result[0] = index / col;
        result[1] = index % col;

        return result;
    }

    private void test() {
        int[][] matrix = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
        int[] result;
        result = binarySearch(matrix, 5);
        System.out.println("x: " + result[0] + ", y: " + result[1]);
    }
}
