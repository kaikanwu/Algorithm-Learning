package array;

import leetcode.Q53_MaximumSubArray;
import org.junit.Assert;
import org.junit.Test;

public class Q53 {


    @Test
    public void test() {

        Q53_MaximumSubArray maximumSubArray = new Q53_MaximumSubArray();

        int[] input = {-3, 4, -1, 2, 3, 4, 5};

        int result = maximumSubArray.maxSubArray(input);

        Assert.assertEquals(17, result);
    }
}
