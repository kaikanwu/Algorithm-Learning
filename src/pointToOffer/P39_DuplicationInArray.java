package pointToOffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * 找出数组中任意一个重复的数字
 */
public class P39_DuplicationInArray {


    /**
     * 一、暴力解法：两次循环得到重复的数组元素
     *
     *  时间复杂度： O（n^2）
     *  空间复杂度：O（1）
     *
     * @param data
     * @return
     */
    public static int getDuplication(int[] data){
        if (data == null || data.length < 2){
            return -1;
        }

        for (int i = 0; i < data.length - 1; i++) {

            for (int j = i + 1; j < data.length; j++) {
                if (data[i] == data[j]){
                   return data[i];
                }
            }
        }
        return -1;
    }


    /**
     * 二、先将数组排序，这样就只要使用一个for循环
     *  时间复杂度：O（n * logn）
     *  空间复杂度 O（1）
     * @param data
     * @return
     */
    public static int getDuplication2(int[] data){
        if (data==null || data.length< 2){
            return -1;
        }
        //Arrays.sort(data); //或者使用内置的函数进行排序
        //也可以手动实现快速排序
        quickSort(data, 0, data.length-1);
        int prev = data[0];
        for (int i = 1; i < data.length; i++){
            if (data[i] == prev){
                return prev;
            }
            else {
                prev = data[i];
            }
        }
        return -1;
    }


    public static void quickSort(int[] data, int start, int end){
        if (start >= end){
            return;
        }

        //快速排序的特点：使用递归
        int bound = partition(data, start, end);
        quickSort(data,start,bound-1);
        quickSort(data,bound+1, end);
    }

    public static int partition(int[] data, int start, int end){
        if (start >= end){
            return end;
        }

        int pivot = data[start];
        int left = start, right = end;
        while (left < right){
            while (left < right && data[right]>=pivot){
                right--;
            }
            if (left<right){
                data[left++] = data[right];
            }
            while (left < right && data[left] < pivot){
                left++;
            }

            if (left<right){
                data[right--] = data[left];
            }
        }
        data[left] = pivot;

        return left;
    }













    public static void main(String[] args){

        int[] data = {9,4,1,2,3,3,6,6,8,0};
        System.out.println(getDuplication(data));

        quickSort(data, 0 , data.length-1);
        for (int i = 0; i < data.length ; i++) {
            System.out.print(data[i]+ " ");
        }

        System.out.println();

        System.out.println(getDuplication2(data));

    }


}
