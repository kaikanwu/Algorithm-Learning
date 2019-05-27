package hua;

import java.util.*;

/**
 * @author kaikanwu
 * @date 18/11/2018
 */
public class HW18 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {

            String input = scanner.nextLine();
            String[] arr = input.split(",");

            int n = Integer.valueOf(arr[0]);
            int m = Integer.valueOf(arr[1]);

            List<Integer> list = new ArrayList<>();

            // 用 list 的remove来做，先添加
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }

            int index= 0;
            // 开始删除被选中的人，删除到 n-1
            for (int i = 1; i < n; i++) {
                index = (index + (m - 1)) % list.size();
                list.remove(index);
            }

            //最后只剩下一个数
            System.out.println(list.get(0));

        }

    }
}
