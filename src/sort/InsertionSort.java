package sort;

/**
 * 直接插入排序：Straight Insertion Sort
 */
public class InsertionSort {

    public static int[] insertionSort(int[] arr){

        for (int i = 1 ; i < arr.length; i++){

            for (int j = i; j > 0 ; j--) {

                if (arr[j] < arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }


    public static void main(String[] args){
        int[] arr = {1,5,3,9,2,4,6};
        insertionSort(arr);

        for (int i : arr) {
            System.out.print( i + " ");
        }
    }



}
