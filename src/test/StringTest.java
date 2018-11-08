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

        // system.in
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String read = null;
        System.out.println("print here:");
        try {
            read = bufferedReader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(read);


    }
}
