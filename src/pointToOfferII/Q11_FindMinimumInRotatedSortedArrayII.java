package pointToOfferII;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2]为[1,2,3,4,5]的一个旋转，该数组的最小值为1。
 */
public class Q11_FindMinimumInRotatedSortedArrayII {

    /**
     * 利用旋转数组的特性，可以通过遍历获取
     * T:O(n)
     * S:O(1)
     */
    public int minArray(int[] numbers) {

        int pre = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < pre) {
                return numbers[i];
            }
            pre = numbers[i];
        }
        return numbers[0];
    }

    public int minArray2(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;

        while (low < high) {
            int pivot = low + (high - low) / 2;

            if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else {
                high--;
            }
        }
        return numbers[low];
    }
}
