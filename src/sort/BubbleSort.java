package sort;

public class BubbleSort {


    /**
     * Time: O（n^2）
     */
    private static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 优化冒泡算法，增加一个标志位，可以减少外层循环的次数
     */
    public static void bubbleSort2(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            boolean changed = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    changed = true;
                }
            }
            if (!changed) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {10, 8, 9, 0, 3, 1, 5};
        int[] arr2 = {6, 3, 1, 0, 55, 3};

//        bubbleSort(arr2);
        bubbleSort2(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
