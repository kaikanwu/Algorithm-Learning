package sort;

public class BubbleSort {

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


    public static void main(String[] args) {

        int[] arr = {10, 8, 9, 0, 3, 1, 5};
        int[] arr2 = {6, 3, 1, 0, 55, 3};

        bubbleSort(arr2);

        for (int i : arr2) {
            System.out.print(i + " " );

        }
    }
}
