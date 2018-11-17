package test;

import java.util.Scanner;

/**
 * @author kaikanwu
 * @date 17/11/2018
 */
public class HWExample2 {


    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String c=sc.next();
        int num=0;
        for(int i=0;i<str.length();i++){
            if(c.equals(String.valueOf(str.charAt(i)))){
                num++;
            }

        }
        System.out.println(num);

    }


    private static int count(String str, String target){

       char[] ch = str.toCharArray();
       char[] ta = target.toCharArray();
       int count = 0;

        for (int i = 0; i < ch.length; i++) {

            if (ch[i] == ta[0]) {
                count++;
            }
        }

        return count;
    }


}
