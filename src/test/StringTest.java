package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author kaikanwu
 * @date 01/11/2018
 */
public class StringTest {
    public static void main(String[] args) throws IOException {

        String s = "12eFG/ TGi.*2";
        String s2 = "12eFG/ TGi.*2";

        s = s.replaceAll("\\p{P}","");
//        s2 = s2.replaceAll("\\p{Punct}", "");
        s2 = s2.replaceAll("\\w", "");


        System.out.println(s);
        System.out.println(s2);
    }
}
