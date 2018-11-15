package test;

import java.io.*;
import java.util.*;

/**
 * @author kaikanwu
 * @date 15/11/2018
 */
public class MSTR1  {


    static String electionWinner(String[] votes) {

        Map<String, Integer> map = new HashMap<>(votes.length);

        for (String name : votes) {

            if (map.containsKey(name)) {
                map.put(name,map.get(name)+1);
            }
            else {
                map.put(name, 1);
            }

        }


        List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator<Map.Entry<String,String>>());



    }
}
