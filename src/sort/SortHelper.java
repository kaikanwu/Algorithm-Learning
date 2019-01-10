package sort;

public class SortHelper {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void printArray(int[] arr) {

        for (int i : arr) {
            System.out.print( i + " ");
        }

        System.out.println();
    }
}
