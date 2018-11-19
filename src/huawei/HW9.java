package huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *  数据表记录包含表索引和数值，请对表索引相同的记录进行合并，
 *  即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 *
 * 输入描述:
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 *
 * 输出描述:
 * 输出合并后的键值对（多行）
 * @author kaikanwu
 * @date 18/11/2018
 */
public class HW9 {

    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);

        while (scanner.hasNext()) {

            int n = scanner.nextInt();
            Map<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {

                int k = scanner.nextInt();
                int value = scanner.nextInt();



                if (map.containsKey(k)) {
                    map.put(k, map.get(k) + value);
                }
                else {
                    map.put(k, value);
                }
            }

            for (Integer k : map.keySet()) {
                System.out.println(k+ " " + map.get(k));

            }


        }


    }
}
