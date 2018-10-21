package sort;

public class SortTest {

    /**
     * Straight Insertion Sort
     * @param arr
     */
//    public static void insertionSort(int[] arr){
//        if (arr == null || arr.length < 2){
//            return;
//        }
//
//        for (int i = 1 ; i < arr.length ; i++) {
//
//            for (int j = i; j > 0  ; j--) {
//
//                if (arr[j]< arr[j-1]){
//                   swap(arr,j, j-1);
//                }
//            }
//        }
//    }
//
//    private static void quickSort(int[] arr, int start, int end){
//
//        if (start > end){
//            return;
//        }
//
//        int bound = partition(arr, start, end);
//        quickSort(arr, start, bound-1);
//        quickSort(arr, bound +1 , end);
//    }
//
//
//    private static int partition(int[] arr, int start, int end){
//
//        int pivot = arr[start];
//        while (start < end){
//
//            while (arr[end] >= pivot && start < end){
//                end--;
//            }
//            if (start < end){
//                arr[start] = arr[end];
//            }
//
//            while (arr[start] <= pivot && start < end){
//                start++;
//            }
//            if (start < end){
//                arr[end] = arr[start];
//            }
//
//        }
//
//        arr[end] = pivot;
//        return end;
//
//    }


    /**
     * swap method
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i , int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

//
//
//    public static void main(String[] args){
//
//        int[] arr = {7,4,5,3,1,0,9,1};
//        int[] arr2 = {7,4,5,3,1,0,9,1};
//
//        insertionSort(arr);
//
//        for (int i: arr) {
//            System.out.print(i + " ");
//        }
//
//        System.out.println();
//        quickSort(arr2, 0, arr2.length - 1 );
//
//        for (int i: arr2) {
//            System.out.print(i + " ");
//        }
//
//
//
//
//    }
}
