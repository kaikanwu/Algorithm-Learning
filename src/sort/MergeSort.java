package sort;

/**
 * 归并排序
 * O（n*logn）
 */
public class MergeSort {


    /**
     * 将数组进行归并排序
     * @param arr 要排序的数组
     * @param temp 辅助数组
     * @param left 左边界
     * @param right 右边界
     */
    public static void mergeSort(int[] arr, int[] temp, int left, int right){
        if (left < right){
            // 将数组一分为二
            int center = (left + right) / 2;
            // 将左边的数组排序（left --> center）
            mergeSort(arr, temp, left, center);
            // 将右边的数组排序（center+1 --> right）
            mergeSort(arr, temp, center + 1, right);
            // 合并这两个数组
            merge(arr, temp, left, center, right);

        }
    }


    /**
     * 合并两个数组， arr[left...center], arr[center+1...right]
     * @param arr
     * @param temp
     * @param left
     * @param center
     * @param right
     */
    public static void merge(int[] arr, int[] temp, int left, int center, int right) {

        int i = left;
        int j = center + 1;

        //通过比较将两个数组合并成一个有序数组，把结果暂时放到辅助数组temp中
        for (int k = left; k <= right; k++) {
            //如果左边的数组取完(比较完)，即i > center
            //这时候只剩下右边数组里的值，直接将右边数组剩下的值copy到temp中
            if (i > center){
                temp[k] = arr[j++];
            }
            //和上同理
            else if (j > right){
                temp[k] = arr[i++];
            }
            //i指针对应的数比j指针对应的数小，将i指针对应的数复制到temp
            else if (arr[i] <= arr[j]) {
                temp[k] = arr[i++];
            }
            //与上同理
            else {
                temp[k] = arr[j++];
            }

        }
        //跳出上一个循环，表示两个数组已经merge好，并且存放在temp中
        // 将辅助数组中的值，重新复制到arr
        for (int k = left; k <= right ; k++) {

            arr[k] = temp[k];
        }
    }


    public static void main(String[] args){


        int[] arr = {6,3,9,0,1,5,3};
        int[] temp = new int[arr.length];
        mergeSort(arr,temp,0, arr.length - 1);

        for (int i :
             arr) {
            System.out.print(i + " ");

        }
    }




}
