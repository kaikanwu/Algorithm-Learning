package pointToOffer;

/**
 * Q: 求 1+2+3+...+ n
 * 要求不能使用乘除法，for,while,if,else,switch case 等关键字
 *
 * A:只能使用位运算了
 *
 * @author kaikanwu
 * @date 22/11/2018
 */
public class P307_Sum {

    public int Sum_Solution(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}
