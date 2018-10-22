package sort;

public class SelectionSort {

    private static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length -1 ; i++) {


            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            SortHelper.swap(arr, minIndex, i);

        }
    }


    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 0, 9, 3};

        selectionSort(arr);
        SortHelper.printArray(arr);

    }
}
