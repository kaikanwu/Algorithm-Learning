package aoc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1 {


    public static Integer calculateFromFile() throws FileNotFoundException {

        BufferedReader br = new BufferedReader(new FileReader("Day1.txt"));

        List<Integer> nums = new ArrayList<>();
        try {

            String line = br.readLine();
            while (line != null) {

                nums.add(Integer.valueOf(line));
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println("lines: " + nums.size());
        Collections.sort(nums);

        int i = 0;
        int j = nums.size() - 1;

        while (i < j) {

            int n1 = nums.get(i);
            int n2 = nums.get(j);

            if (n1 + n2 > 2020) {
                j--;
            } else if (n1 + n2 < 2020) {
                i++;
            } else {
                return n1 * n2;
            }
        }
        return 0;
    }


    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(calculateFromFile());
    }




}
