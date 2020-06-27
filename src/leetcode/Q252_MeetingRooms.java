package leetcode;

import java.util.List;

/**
 * @author kaikanwu
 * created on 6/27/2020
 */
public class Q252_MeetingRooms {


    public class Interval {

        int start;
        int end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }


    /**
     * Time:  O(n*log(n))   (actually: O(n*log(n)) + O(n) )
     * Space: O(1)
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // 1. 先根据区间的「开始时间」对数据进行排序，这里可以用 jdk 1.8 提供的  List.sort() 方法
        // （这里先花费 n*log(n) 的时间进行排序）
        intervals.sort((a, b) -> a.start - b.start);

        // 2. （这里再花费 O(n) 的时间去对比相邻的区间）
        for (int i = 0; i < intervals.size() - 1; i++) {
            if (intervals.get(i).end > intervals.get(i + 1).start) {
                return false;
            }
        }
        return true;
    }


}

