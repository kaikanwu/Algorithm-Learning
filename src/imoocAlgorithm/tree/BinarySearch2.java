package imoocAlgorithm.tree;

/**
 *  二分查找法 --- 递归法
 * @author kaikanwu
 * @date 07/11/2018
 */
public class BinarySearch2 {

    private BinarySearch2() {

    }

    /**
     * 递归方法
     */
    public static int find(Comparable[] arr, Comparable target) {

        return find(arr, 0, arr.length - 1, target);
    }


    /**
     * 辅助函数
     */
    private static int find(Comparable[] arr, int l, int r, Comparable target) {

        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;

        if (arr[mid].compareTo(target) == 0) {
            return mid;
        }
        else if (arr[mid].compareTo(target) > 0) {
            return find(arr, l, mid - 1, target);
        }
        else {
            return find(arr, mid + 1, r, target);
        }

    }


    public static void main(String[] args) {

        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
       int i =  BinarySearch2.find(arr, 5);
        System.out.println(i);

    }
}
