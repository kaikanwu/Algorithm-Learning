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
     * Time:  O(n*log(n))
     * Space: O(1)
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);

        for (int i = 0; i < intervals.size() - 1; i++) {
            if (intervals.get(i).end > intervals.get(i + 1).start) {
                return false;
            }
        }
        return true;
    }


}

