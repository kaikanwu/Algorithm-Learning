package pointToOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  Q: 字符串的排列
 *  输入一个字符串，打印出该字符串中字符的所有排列。
 *  例如输入 abc, 则打印出 abc、acb、bac、bca、cab、cba
 *
 *
 *  A:
 *  书中的解法是，固定一个元素，和其他元素交换
 *
 *
 *
 * @author kaikanwu
 * @date 13/11/2018
 */
public class P197_StringPermutation {

    private ArrayList<String> result = new ArrayList<>();

    public ArrayList<String> permutation(String str) {

        if (str.length() == 0) {
            return result;
        }

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length], new StringBuilder());
        return result;
    }

    private void backtracking(char[] chars, boolean[] hasUsed, StringBuilder sb) {

        if (sb.length() == chars.length) {
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i]) {
                continue;
            }
            // 为了保证不重复
            if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1]) {
                continue;
            }
            hasUsed[i] = true;
            sb.append(chars[i]);
            backtracking(chars, hasUsed, sb);
            sb.deleteCharAt(sb.length() - 1);
            hasUsed[i] = false;
        }


    }



}
