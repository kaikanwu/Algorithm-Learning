package sort;

public class ShellSort {


    /**
     *  希尔排序 一
     *  插入排序的升级版
     *  可以在处理大数据量的情况下，保持效率
     * @param arr 等待排序的数组
     */
    public static void shellSort(int[] arr){
        for (int gap = arr.length/2; gap > 0; gap/=2){

            for (int i = gap; i < arr.length ; i++) {

                int j = i;
                while ((j-gap) >= 0 && arr[j] < arr[j-gap]){
                    int temp = arr[j];
                    arr[j] =  arr[j-gap];
                    arr[j-gap] = temp;
                    //
                    j -= gap;
                }
            }
        }
    }



    public static void shellSort2(int[] arr){

        int n = arr.length;
        for (int gap = n/2; gap > 0; gap /= 2){
            //
            for (int i = gap; i < n ; i++){
                insertI(arr, gap, i);
            }
        }
    }



    private static void insertI(int[] arr, int gap ,int i ){
        int inserted = arr[i];
        int j;

        for (j = i-gap; j >= 0 && inserted < arr[j]; j -= gap){
            arr[j+ gap] = arr[j];
        }
        arr[j+gap] = inserted;
    }

    /**
     * for test
     * @param args
     */
    public static void main(String[] args){
        int[] arr ={6,4,2,9,1,0};
        int[] arr2 ={6,4,2,9,1,0};
        shellSort(arr);
        shellSort2(arr2);

        for (int i : arr
             ) {

            System.out.print( i +" ");

        }
        System.out.println();
        System.out.println("=========");
        for (int i : arr2
                ) {

            System.out.print( i +" ");

        }

    }





}
