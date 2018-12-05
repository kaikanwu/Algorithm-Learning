package leetcode;

/**
 *  Q:  移动零
 *      给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 *      示例:
 *      输入: [0,1,0,3,12]
 *      输出: [1,3,12,0,0]
 *
 *      说明:
 *      必须在原数组上操作，不能拷贝额外的数组。
 *      尽量减少操作次数。
 *
 * @author kaikanwu
 * @date 05/12/2018
 */
public class Q283_MoveZeros {
    /**
     * 方法一
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param nums
     */
    public static void moveZeroes(int[] nums) {


        int i = 0;
        for (int num : nums) {

            if (num != 0) {
                nums[i] = num;
                i++;
            }
        }
        for (int j = i; j < nums.length ; j++) {
            nums[j] = 0;
        }
    }

    /**
     * 方法二 交换
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {


        int i = 0;

        for (int j = 0; j < nums.length; j++) {

            if (nums[j] != 0) {
                // 这样可以不让数字自己和自己交换
                if (i != j) {
                    swap(nums,i++, j);
                }
                else {
                    i ++;
                }

            }
        }

    }

    private static void swap(int[] arr ,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};

        moveZeroes2(nums);
        for (int i : nums) {

            System.out.print(i);
        }
    }
}
