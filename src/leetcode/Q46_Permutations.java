package leetcode;

import java.util.*;

/**
 *  Q:  给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 *  A:  TODO：这道题应该有更好的解
 *
 * @author kaikanwu
 * @date 13/01/2019
 */
public class Q46_Permutations {


    /**
     *  Time: O(n*n!), Space:O(n)
     *  由于是递归，时间复杂度挺高的，但还是通过测试用例了。
     */
    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        for (int num: nums) {
            list.add(num);
        }

        permuteRec(list, 0, result);
        return result;

    }

    private void permuteRec(List<Integer> nums, int start, List<List<Integer>> result) {
        if (start == nums.size()) {
            result.add(new ArrayList<>(nums));
        }
        else {
            for (int i = start; i < nums.size() ; i++) {
                Collections.swap(nums, i, start);
                permuteRec(nums, start + 1, result);
                Collections.swap(nums, i, start);
            }
        }

    }

}
