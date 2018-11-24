package leetcode;

/**
 * @author kaikanwu
 * @date 24/11/2018
 */
public class Q167_TwoSum_II {


    public int[] twoSum(int[] numbers, int target) {

        int i = 0;
        int j = numbers.length-1;
        int[] result = new int[2];

        // 不能使用重复的元素，所以条件为 i<j
        while (i < j) {

            int sum = numbers[i] + numbers[j];

            if (sum == target) {
                result[0] = i+1;
                result[1] = j+1;
                return result;
            }

            else if (sum < target) {
                i++;
            }
            else {
                j--;
            }

        }
        return result;


    }


    public static void main(String[] args) {

        int[] arr = {2,7,11,15};

        Q167_TwoSum_II t = new Q167_TwoSum_II();
        int[] result = t.twoSum(arr, 9);
        for (int i: result
             ) {

            System.out.println(i);

        }


    }


}
