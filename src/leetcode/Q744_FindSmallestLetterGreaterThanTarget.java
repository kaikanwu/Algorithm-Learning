package leetcode;

/**
 *  Q:  给定一个只包含小写字母的有序数组letters 和一个目标字母 target，
 *      寻找有序数组里面比目标字母大的最小字母。
 *      数组里字母的顺序是循环的。
 *      举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，
 *      则答案返回 'a'。
 *
 *  A:  在一个有序数组里查找一个目标，使用<二分查找>。
 *
 * @author kaikanwu
 * @date 04/12/2018
 */
public class Q744_FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target){

        int n = letters.length;
        int l = 0;
        int r = n-1;

        while (l <= r) {
            int m = l+ (r-l)/2;

            if (letters[m] <= target) {
                l = m + 1;
            }
            else {
                r = m - 1;
            }

        }
        // 输入的有序数组是循环的，所以如果 l >= n ，目标就是数组的第一个数
        // 否则 就是 arr[l]
        return l < n ? letters[l] : letters[0];
    }
}
