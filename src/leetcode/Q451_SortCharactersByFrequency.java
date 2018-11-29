package leetcode;

import java.util.*;

/**
 *
 *  Q: 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *  返回排序好的字符串
 *
 *
 * @author kaikanwu
 * @date 29/11/2018
 */
public class Q451_SortCharactersByFrequency {

    public String frequencySort(String s) {

        Map<Character, Integer> frequencyForNum = new HashMap<>();
        for (char c:s.toCharArray()) {

            // HashMap 的新方法（from jdk 1.8）, getOrDefault
            frequencyForNum.put(c, frequencyForNum.getOrDefault(c, 0) + 1);
        }

        List<Character>[] frequencyBucket = new ArrayList[s.length() + 1];
        for (char c: frequencyForNum.keySet()) {

            int f = frequencyForNum.get(c);
            if (frequencyBucket[f] == null) {
                frequencyBucket[f] = new ArrayList<>();
            }
            // 把同一频率的字符放在同一个桶中
            frequencyBucket[f].add(c);
        }

        //重新排列字符串
        StringBuilder sb = new StringBuilder();
        // 从后往前遍历
        for (int i = frequencyBucket.length - 1; i > 0; i--) {
            if (frequencyBucket[i] == null) {
                continue;
            }
            for (char c : frequencyBucket[i]) {
                for (int j = 0; j <i ; j++) {
                    sb.append(c);
                }
            }

        }
        return sb.toString();


    }
}
