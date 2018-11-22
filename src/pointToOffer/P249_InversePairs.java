package pointToOffer;

/**
 *  Q: 数组中的逆序对
 *  如果数组中前一个数字大于后面的数字，则这两个数组构成一个逆序对。
 *  输入一个数组，求该数组的逆序对的总数。
 *
 *  example: {7,5,6,4} -> {7,6},{7，5}，{7，4}，{5，4}，{5，6}， 个数为 5个
 *
 *
 *  A: 使用归并排序的方法
 * @author kaikanwu
 * @date 22/11/2018
 */
public class P249_InversePairs {


    private  long count = 0;
    /**
     * 提前在方法外声明辅助函数，
     */
    private  int[] temp;


    public int inversePaires(int[] arr) {
        temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
        return (int) (count % 1000000007);
    }

    private void mergeSort(int[] arr, int l, int r) {

        if (r - l < 1) {
            return;
        }

        int m = l + (r - l) / 2;

        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    private void merge(int[] arr, int l, int m, int r) {
        int i = l;
        int j = m+1;
        int k = l;

        while (i <= m || j <= r) {
            if (i > m) {
                temp[k] = arr[j++];
            }
            else if (j > r) {
                temp[k] = arr[i++];
            }
            else if(arr[i] < arr[j]){
                temp[k] = arr[i++];
            }
            else {
                temp[k] = arr[j++];
                this.count += m -i +1;
            }
            k++;
        }
        for (k = l; k <= r; k++) {
            arr[k] = temp[k];
        }
    }





}
