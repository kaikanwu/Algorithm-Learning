package leetcode;

/**
 *  Q:  给定一个排序数组，你需要在原地删除重复出现的元素，
 *      使得每个元素只出现一次，返回移除后数组的新长度。
 *      不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 *      示例 2:
 *      给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *      函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *      你不需要考虑数组中超出新长度后面的元素。
 *
 *
 *  A： 因为需要原地删除，所以这里用i指针代表删除后的数组，j指针指向最初的数组，两个指针都操作同一个数组。
 *
 *
 * @author kaikanwu
 * @date 05/12/2018
 */
public  class Q26_RemoveDuplicatedFromSortedArray {

    public static int removeDuplicates(int[] nums) {

        // 注意起始都是 1
        int i = 1;
        for (int j = 1; j < nums.length; j++) {

            if (nums[j] != nums[j - 1]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4,5,5};
        System.out.println(removeDuplicates(arr));

    }
}
