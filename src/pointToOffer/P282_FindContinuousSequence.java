package pointToOffer;

import java.util.ArrayList;

/**
 *  Q: 和为 s 的连续正数序列
 *  输入一个正数 s， 打印出所有和为 s 的连续正数序列（至少含有两个数）
 *  例如，输入15，由于 1+2+3+4+5 = 15， 4+5+6 = 15， 7+8 =15；
 *  所以答案是 1~5， 4~6， 7~8
 *
 *  A
 *
 *
 *
 * @author kaikanwu
 * @date 22/11/2018
 */
public class P282_FindContinuousSequence {


    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {


        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int start = 1;
        int end = 2;
        int curSum = 3;

        while (end < sum) {

            if (curSum > sum) {

                curSum -= start;
                start++;
            }
            else if (curSum < sum){
                end++;
                curSum += end;
            }
            else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                result.add(list);
                curSum -= start;
                start++;
                end++;
                curSum += end;

            }
        }

        return result;

    }


}
