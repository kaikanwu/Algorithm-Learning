package pointToOffer;

/**
 *  Q: 旋转数组的最小数字
 *  把一个数组最开始的若干个元素搬到末尾，称为数组的旋转。
 *  如 1，2，3，4，5 =》 3，4，5，1，2
 *  求一个原本递增的数组旋转后的最小数字。
 *
 *  A:
 *  1. 可以用遍历直接获得最小的值，但这肯定不符合面试的要求。
 *  2. 注意题目中的旋转，可以利用这个特点，发现数组被分成了两个递增排序的子数组
 *  3. 在一个有序数组中查找一个元素可以使用二分查找法，这种算法的时间复杂度是O（logN）
 *  4. 本题可以修改二分查找法进行求解
 *
 * @author kaikanwu
 * @date 30/10/2018
 */
public class P82_MinNumberInRotatedArray {


    private static int minNumberInRotateArray(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= arr[high]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }

        return arr[low];

    }


    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        System.out.println(minNumberInRotateArray(arr));
    }




}
