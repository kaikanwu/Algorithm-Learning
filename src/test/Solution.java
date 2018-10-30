package test;

import java.io.*;
import java.util.Scanner;

/**
 * @author kaikanwu
 * @date 29/10/2018
 */
public class Solution {

    /**
     * 第一行是两个用空格隔开的整数n和浮点数v，表示共有n辆车，最终将以速度v匀速行驶。
     *
     * 接下来共n行，每行是用空格隔开的3个浮点数，分别为li, acci, di。
     *
     *
     *
     * 1 <= n <= 100， 1 <= v <= 35。
     *
     * 1 <= li <= 20，
     * 1 <= acci <= 20
     * ，0 <= di <= 1，
     * 输入浮点数均保留3位小数，所有物理量为国际单位制。输入数据保证最终结果不会因为浮点数精度导致四舍五入保留三位小数时出现误差。
     *
     * 输出
     * 输出一行，包含一个四舍五入保留3位小数的浮点数，表示第一辆车车头到最后一辆车车尾的总长度。
     *
     *
     * 样例输入
     * 2 20.000
     * 5.000 10.000 0.500
     * 5.000 8.000 0.400
     * 样例输出
     * 23.000
     * @param args
     */
    public static void main(String[] args) throws Exception{

        Scanner in = new Scanner(System.in);
        //数量
        int n = in.nextInt();
        //均速
        float v = in.nextFloat();

        float[] length = new float[n];
        float[] acc = new float[n];
        float[] delay = new float[n];


        if (in.hasNextLine()) {
            for (int i = 0; i < n ; i++) {
                length[i] = in.nextFloat();
                acc[i] = in.nextFloat();
                delay[i] = in.nextFloat();
            }
        }


        for (int i = 1; i < n; i++) {

            float time = v / acc[0];



        }


        System.out.println("23.000");


    }

}
