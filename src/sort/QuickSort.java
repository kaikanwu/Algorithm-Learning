package sort;

public class QuickSort {

    public static void quickSort(int[] arr, int start, int end){
        if (start > end){
            return;
        }

        int bound = partition(arr,start,end);
        quickSort(arr, start, bound-1);
        quickSort(arr, bound + 1, end);

    }


    public static int partition(int[] arr, int start, int end){

        int pivot = arr[start];

        //当这个while循环结束的时候，说明两侧的指针相遇
        while (start < end) {

            //从右向左看
            while (arr[end] >= pivot && start < end){
                //如果右侧的数比pivot大，则不需要交换，将 end -1,继续向左边扫描
                end--;
            }

            if (start < end){
                //跳出了while 循环，说明在右侧找到了比pivot小的数，所以要进行交换
                //注意，这里 arr[start] 值，在之前已经赋给了pivot。
                arr[start] = arr[end];
            }


            //从左向右看，依次和基数pivot比较
            while (arr[start] <= pivot && start < end){
                //如果左侧的数比基数小，则+1，继续比较
                start++;
            }

            //跳出循环，说明左侧的数大于了基数，需要作交换
            if (start < end){
                //因为arr[end] 的值已经付给了arr[start],所以这里的值空了，
                // 可以将arr[start] 赋给 array[end]
                arr[end] = arr[start];
            }

        }

        //再将基数放回去。
        arr[end] = pivot;

        //最后end 和 start 是同一个数，指向同一个位置，这个位置左侧的数都比pivot小，
        //右侧的数都比pivot大。
        return end;
    }



    public static void main(String[] args){
        int[] arr = {99,5,3,9,2,4,6,1,2,10,66};
        quickSort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.print(i + " " );
        }
    }

}
