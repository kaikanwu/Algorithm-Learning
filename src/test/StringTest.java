package test;

/**
 * @author kaikanwu
 * @date 01/11/2018
 */
public class StringTest {
    public static void main(String[] args) {

        String s1 = new String("aaa");
        String s2 = new String("aaa");

        String s3 = "aaa";
        String s4 = "aaa";

        String s5 = s1.intern();
        String s6 = s3.intern();

        System.out.println(s1 == s2);
        System.out.println(s3 == s4);
        System.out.println(s2 == s4);
        System.out.println(s5 == s6);



    }
}
