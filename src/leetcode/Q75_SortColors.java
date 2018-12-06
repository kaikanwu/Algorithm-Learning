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
 *  解题思路：   从答案来看，这道题可以看做是一个排序问题，当没有特定的思路时，应该想到使用
 *             我们常用的排序算法来解决。
 *            （也就是我们遇到问题时，首先应该想到先解决这个问题，再去优化它）
 *
 *
 *
 * @author kaikanwu
 * @date 29/11/2018
 */
public class Q75_SortColors {

    /**
     *  方法一：三路快速排序
     *  这里的三路是：=0， =1 ，=2
     *
     *  TC: O(N)
     *  SC: O(1)
     *  相比较方法二：只遍历了数组一遍
     * @param nums
     */
    public void sortColors(int[] nums) {
        /**
         *  nums[0...zero] == 0
         */
        int zero = -1;

        /**
         * nums[two...n-1] == 2
         */
        int two = nums.length;

        int i = 0;
        while (i < two) {
            if (nums[i] == 0) {
                zero++;
                swap(nums,i ,  zero);
                i++;
            }
            else if (nums[i] == 2) {
                // 将 two 往前一位，扩张元素为2的集合
                two--;
                swap(nums, i,two);
            }
            else {
                // nums[i] == 1 时，直接 i++
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     *  方法二： 使用计数排序
     *  这个方法更好理解！但是缺点是比较繁琐，如果元素的个数比较多，代码量也会增加很多
     *  time complexity: O(n)
     *  space complexity: O(K) k 为元素的取值范围，这里问题里就是 3。（如果像这里 k =3, 也就是常数，其实 sc 也相当于 O（1））
     * @param nums
     */
    public void sortColors2(int[] nums) {


        int[] count = new int[3];

        // count[0] 存放的是 0 元素的个数， count[1] 存放的是元素 1 的个数
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        // 将数组重新赋值
        int index = 0;
        for (int i = 0; i < count[0] ; i++) {
            nums[index++] = 0;
        }
        for (int i = 0; i <count[1] ; i++) {

            nums[index++] = 1;
        }
        for (int i = 0; i < count[2]; i++) {
            nums[index++] = 2;
        }

    }


}
