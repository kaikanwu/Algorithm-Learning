package pointToOffer;

import java.util.PriorityQueue;

/**
 *  Q: 数据流中的中位数
 *  如果从数据流中读出奇数个数值，那么中位数就是所有数值排序过后位于中间的数值。
 *  如果读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 *  A： 主要就是对比各个数据结构在这个问题上的表现，
 *      详见P215分析比较
 *
 *
 * @author kaikanwu
 * @date 19/11/2018
 */
public class P214_StreamMedian {

    /**
     * 大根堆，存储左半边元素
     */
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);

    /**
     * 小根堆，存储右半边的元素，并且右半边都大于左半边
     */
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    /**
     *  当前数据流读入的元素个数
     */
    private int n = 0;


    /**
     *  插入的元素要保证两个堆存于平衡状态
     *  实现细节：p216
     * @param val
     */
    public void insert(Integer val) {

        if (n % 2 == 0) {
            // n为偶数的情况下，要插入到右半边。
            // 但是由于右半边的元素要比左半边大，新插入的元素不一定
            // 所以先将元素插入到左边的最大堆，然后取出最大堆的最大元素，插入到右半边。
            left.add(val);
            right.add(left.poll());
        }
        else {
            // 和上面同理
            right.add(val);
            left.add(right.poll());
        }

        n++;
    }


    public Double getMedian() {

        if (n % 2 == 0) {
            return (left.peek() + right.peek()) / 2.0;
        }
        else {
            return (double)right.peek();
        }

    }

}
