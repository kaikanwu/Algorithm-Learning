package leetcode;

import java.util.*;


/**
 *  Q:  给定两个数组，编写一个函数来计算它们的交集。
 *
 *      示例 1:
 *      输入: nums1 = [1,2,2,1], nums2 = [2,2]
 *      输出: [2]
 *
 *      示例 2:
 *      输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 *      输出: [9,4]
 *
 *      说明:
 *      输出结果中的每个元素一定是唯一的。
 *      我们可以不考虑输出结果的顺序。
 * @author kaikanwu
 * @date 07/12/2018
 */
public class Q349_IntersectionOfTwoArrays {

    /**
     *  方法一
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {


        Map<Integer, Integer> map = new HashMap<>(nums1.length+nums2.length);

        for (int i :nums1) {

            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
            else {
                map.put(i,  1);
            }


        }
        for (int i :nums2) {

            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
            else {
                map.put(i, 1);
            }

        }

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();

        int[] result = new int[nums1.length + nums2.length];
        int i = 0;

        for (Map.Entry<Integer,Integer> entry :set) {
            if (entry.getValue() > 1) {
                result[i] = entry.getKey();
                i++;
            }
        }
        return result;
    }


    public int[] intersection2(int[] nums1, int[] nums2) {

        TreeSet<Integer> recordSet = new TreeSet<>();
        for (int i :nums1) {

            recordSet.add(i);
        }

        TreeSet<Integer> resultSet = new TreeSet<>();
        for (int i: nums2) {

            if (recordSet.contains(i)) {
                resultSet.add(i);
            }
        }

        int[] result = new int[resultSet.size()];

        int j = 0;
        for (Integer i:resultSet) {

            result[j] = i;
            j++;
        }
        return result;
    }




}
