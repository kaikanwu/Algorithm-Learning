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

        ClassLoader loader = StringTest.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader);
            loader = loader.getParent();
        }

    }
}
