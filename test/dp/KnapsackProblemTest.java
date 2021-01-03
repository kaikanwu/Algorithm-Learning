package dp;

import org.junit.Test;

public class KnapsackProblemTest {


    @Test
    public void test1() {
        KnapsackProblem kp = new KnapsackProblem();
        int result = kp.solveDP();
        System.out.println(result );
    }
}
