package huawei;

import java.util.Scanner;

/**
 *  字符串最后一个单词的长度
 * @author kaikanwu
 * @date 18/11/2018
 */
public class HW3{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        String[] arr = str.split(" ");
        System.out.println(arr[arr.length-1].length());

    }

}