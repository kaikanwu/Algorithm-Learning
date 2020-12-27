import dp.KnapsackProblem;
import org.junit.Assert;
import org.junit.Test;

public class DpTest {



    @Test
    public void testKnapsackProblem() {
        KnapsackProblem problem = new KnapsackProblem();
        int result = problem.solveDP();
        Assert.assertNotNull(result);
        System.out.println(result);

    }
}
