package leetcode;

import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length < 2 ){
            return new int[]{-1,-1};
        }

        int[] result = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length ; i++) {

            if (map.containsKey(target - nums[i])){

                result[0] = map.get(target-nums[i]);
                result[1] = i;
                break;
            }

            map.put(nums[i] , i);
        }

        return result;





    }
}
