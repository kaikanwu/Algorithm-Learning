package sort;

public class SelectionSort {

    private static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length ; j++) {


                if (arr[j] < arr[i]) {

                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;

                }
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 0, 9, 3};

        selectionSort(arr);

        for (int i : arr
             ) {

            System.out.print(i + " ");

        }



    }
}
