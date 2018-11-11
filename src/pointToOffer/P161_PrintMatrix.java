package pointToOffer;

import java.util.ArrayList;

/**
 *  Q: 顺时针打印矩阵
 *  输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。例如，输入一下矩阵：
 *
 *  1   2   3   4
 *  5   6   7   8
 *  9   10  11  12
 *  13  14  15  16
 *
 *  打印出的顺序应该是：1，2，3，4，8，12，16，15，14，13，9，5，6，7，11，10
 *
 *
 *
 * @author kaikanwu
 * @date 11/11/2018
 */
public class P161_PrintMatrix {

    public ArrayList<Integer> printMatrix(int[][] matrix) {

        ArrayList<Integer> result = new ArrayList<>();

        int r1 = 0;
        int r2 = matrix.length - 1;
        int c1 = 0;
        int c2 = matrix[0].length - 1;

        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++) {
                result.add(matrix[r1][i]);
            }
            for (int i = r1 + 1; i <= r2; i++) {
                result.add(matrix[i][c2]);
            }
            if (r1 != r2) {
                for (int i = c2 - 1; i >= c1; i--) {
                    result.add(matrix[r2][i]);
                }
            }
            if (c1 != c2) {
                for (int i = r2 - 1; i > r1; i--) {
                    result.add(matrix[i][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return result;
    }

}
