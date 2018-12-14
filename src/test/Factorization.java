package test;

/**
 * @author kaikanwu
 * @date 12/12/2018
 */
public class Factorization {


    public static void factorization(int n) {


        for (int i = 2; i <= n; i++) {

            while (n % i == 0) {
                System.out.print(i+ " ");
                n = n / i;
            }
        }

        
    }


    public static void main(String[] args) {


        factorization(60);
    }
}
