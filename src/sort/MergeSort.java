package sort;

import java.util.Arrays;

/**
 * 归并排序
 * O（n*logn）
 */
public class MergeSort {


    /**
     * 一、归并排序
     *
     * 这里是归并排序的自顶向下的排序（使用递归）
     *
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
     * Merge 函数
     *
     * 合并两个数组， arr[left...center], arr[center+1...right]
     * 注意这里的边界，都是前闭后必
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


    /**
     * 二、归并排序 - 自底向上 Bottom Up
     * 使用迭代
     *
     * @param arr
     * @param temp
     */
    public static void mergeSortBU(int[] arr,int[] temp) {
        int n = arr.length;

        //第一轮循环，对进行merge的元素个数进行遍历
        //也就是，第一轮看一个元素，第二轮看两个元素，4，8...
        for (int sz = 1; sz <= n; sz += sz) {

            //第二轮：每一轮在归并的过程中，元素的起始位置
            // 也就是第一次对，0 ~ size-1, size ~ 2*size -1  进行归并,
            // 然后就是 2*size ~ 3*size -1 , 3*size ~ 4*size -1 进行归并
            for (int i = 0; i < n - sz; i += sz + sz) {
                // 这里当数组merge到数组后端的时候，后面一段的数组长度可能不足一个 size 大小
                merge(arr, temp, i, i + sz - 1, Math.min(i + sz + sz - 1, n-1));
            }
        }
    }


    public static void main(String[] args){


        int[] arr = {6,3,9,0,1,5,3};
        int[] temp = new int[arr.length];
        mergeSort(arr,temp,0, arr.length - 1);


        int[] arr2 = arr.clone();
        mergeSortBU(arr2, temp);

        SortHelper.printArray(arr);
        System.out.println("============");

        SortHelper.printArray(arr2);
    }




}
