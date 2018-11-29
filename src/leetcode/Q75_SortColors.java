package leetcode;

/**
 *  Q:给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 *  此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 *  输入: [2,0,2,1,1,0]
 *  输出: [0,0,1,1,2,2]
 *
 *  A: 这是经典的荷兰国旗问题。
 *  它是三向切分快速排序的一种变种，在三向切分快速排序中，每次切分都将数组分为三个区间：
 *  小于切分元素，等于切分元素，大于切分元素。
 *
 *  在这道题目中，是将数组分为3个区间：等于红色，等于白色，等于蓝色。
 *
 *
 *
 * @author kaikanwu
 * @date 29/11/2018
 */
public class Q75_SortColors {

    public void sortColors(int[] nums) {
        int zero = -1;
        int one = 0;
        int two = nums.length;

        while (one < two) {
            if (nums[one] == 0) {
                swap(nums, ++zero, one++);
            }
            else if (nums[one] == 2) {
                swap(nums, --two, one);
            }
            else {
                ++one;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
