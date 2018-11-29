package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 *  在未排序的数组中找到第 k 个最大的元素。
 *  请注意，你需要找的是数组排序后的第 k 个最大的元素，
 *  而不是第 k 个不同的元素。
 *
 * @author kaikanwu
 * @date 29/11/2018
 */
public class Q215_KthLargestElementInAnArray {

    /**
     * 方法一：直接使用排序
     *
     *  TC:O(N * log N), SC: O(1)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 方法二：使用堆排序，维护一个最小堆,
     *  TC: O(N*logK), SC: O(K)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {

        // 小根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int val : nums) {

            priorityQueue.offer(val);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();

    }

}
