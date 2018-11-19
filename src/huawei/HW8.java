package huawei;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。
 * 如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 *
 * @author kaikanwu
 * @date 18/11/2018
 */
public class HW8 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNext()) {
            double d = scanner.nextDouble();
            System.out.println(Math.round(d));
        }

    }
}
