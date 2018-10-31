package pointToOffer;

/**
 *
 *  Q： 用小矩阵去覆盖大矩阵
 *
 *  A： 仍然是斐波那契数列
 * @author kaikanwu
 * @date 30/10/2018
 */
public class P79_RectCover {


    /**
     * 方法一：循环迭代
     * @param n
     * @return
     */
    public static int rectCover(int n) {
        if (n <= 2) {
            return n;
        }

//        int pre2 = 1, pre1 = 2;
//        int result = 0;
//        for (int i = 2; i < n; i++) {
//            result = pre2 + pre1;
//            pre2 = pre1;
//            pre1 = result;
//        }
        int f1 = 1;
        int f2 = 2;
        int result = f1 + f2;
        for(int i = 3; i < n; i++) {
           f1 = f2;
           f2 = result;
           result = f1 + f2;
        }




        return result;
    }


    /**
     * 方法二：递归
     * @param n
     * @return
     */
    public static int rectCover2(int n) {
        if (n <= 2) {
            return n;
        }

        else {
            return rectCover2(n - 1) + rectCover2(n - 2);
        }
    }


    public static void main(String[] args) {
        int n = 10;
        System.out.println(rectCover(n));
        System.out.println("========");
        System.out.println(rectCover2(n));
    }
}
