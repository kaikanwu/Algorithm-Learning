package pointToOffer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 队列的最大值
 * Q1: 滑动窗口的最大值
 * 给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
 *
 * example: {2,3,4,2,6,5,1} size =3 ,
 * 那么一共存在 6 个滑动窗口，最大值分别为{4，4，6，6，6，5}
 *
 * @author kaikanwu
 * @date 22/11/2018
 */
public class P288_MaxInWindows {


    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (size > num.length || size < 1){
            return ret;
        }

        /* 大顶堆 */
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < size; i++){
            heap.add(num[i]);
        }

        ret.add(heap.peek());
        /* 维护一个大小为 size 的大顶堆 */
        for (int i = 0, j = i + size; j < num.length; i++, j++) {
            heap.remove(num[i]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }
}
