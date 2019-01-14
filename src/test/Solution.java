package test;

import java.io.*;
import java.util.*;

/**
 * @author kaikanwu
 * @date 29/10/2018
 */
public class Solution {
    public int removeDuplicates(int[] nums) {


        for (int i = 1; i < nums.length; i++) {
            if (i + 1 >= nums.length) {
                return nums.length;
            }

            if (nums[i] == nums[i-1]) {
                nums[i] = nums[i + 1];
            }
        }

        return nums.length;

    }


}
