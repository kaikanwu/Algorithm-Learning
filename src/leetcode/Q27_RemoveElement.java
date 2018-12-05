package leetcode;

/**
 *  Q:  移除元素
 *      给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，
 *      返回移除后数组的新长度。
 *      不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *      元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 *      示例 1:
 *      给定 nums = [3,2,2,3], val = 3,
 *      函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *      你不需要考虑数组中超出新长度后面的元素。
 *
 *
 * @author kaikanwu
 * @date 05/12/2018
 */
public class Q27_RemoveElement {
    public static int removeElement(int[] nums, int val) {


        int k = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) {
                nums[k++] = nums[i];
            }

        }
        return k;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 3};
        int[] arr2 = {0, 1, 2, 2, 3, 4, 0, 2};
        System.out.println(removeElement(arr2, 2));

    }

}
