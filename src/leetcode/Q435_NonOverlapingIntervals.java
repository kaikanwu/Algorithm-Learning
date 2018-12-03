package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 *  Q:  "不重叠的区间个数"
 *      给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 *  A： 使用贪心算法。
 *      先计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。
 *      在每次选择中，区间的结尾最为重要，选择的区间结尾越小，留给后面的区间空间越大，
 *      那么后面能够选择的区间个数也就越大。
 *      按区间的结尾进行排序，每次选择结尾最小，并且和前一个区间不重叠的区间。
 *
 * @author kaikanwu
 * @date 03/12/2018
 */
public class Q435_NonOverlapingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {

        if(intervals.length == 0){
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o.end));
        int count = 1;
        int end = intervals[0].end;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < end) {
                continue;
            }
            end = intervals[i].end;
            count++;
        }
        return intervals.length - count;

    }
}

/**
 *  The definition of Interval(区间)
 */
class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
}
