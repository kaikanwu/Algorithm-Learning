package hua;

import java.util.Scanner;
import java.util.TreeSet;

/**
 *  明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，
 *  他先用计算机生成了N个1到1000之间的随机整数（N≤1000）
 *  ，对于其中重复的数字，只保留一个，把其余相同的数去掉，
 *  不同的数对应着不同的学生的学号。
 *  然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。
 *  请你协助明明完成“去重”与“排序”的工作
 *  (同一个测试用例里可能会有多组数据，希望大家能正确处理)。
 *
 * @author kaikanwu
 * @date 18/11/2018
 */
public class HW4 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            TreeSet<Integer> set = new TreeSet<>();

            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                set.add(scanner.nextInt());
            }
            

            for (Integer i :set
                    ) {
                System.out.println(i);

            }

        }







    }



}
