package imoocAlgorithm.tree;

/**
 *  二分查找 --- 迭代版
 *  O(logn)
 *
 *  特别注意边界问题
 * @author kaikanwu
 * @date 07/11/2018
 */
public class BinarySearch {

    /**
     * 我们的算法不允许产生实例
     */
    private BinarySearch() {

    }

    public static int find(Comparable[] arr, Comparable target) {

        // 在 arr[l,r] 的返回里查找 target
        int l = 0, r = arr.length - 1;
        while (l <= r) {

//            int mid = (l+r)/2;
//            这是为了防止极端情况下， l+r 造成整型溢出（超过了int的最大范围）
            int mid = l + (r - l) / 2;
            if (arr[mid].compareTo(target) == 0) {
                return mid;
            }

            // arr[l,mid-1]中寻找target
            if (arr[mid].compareTo(target) > 0) {
                r = mid - 1;
            }
            // arr[mid+1, r]中寻找target
            else {
                l = mid + 1;
            }
        }
        // 数组中没有target
        return -1;
    }


    public static void main(String[] args) {
        int n = 100;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Integer(i);
        }


        System.out.println(BinarySearch.find(arr, 1));
    }

}
