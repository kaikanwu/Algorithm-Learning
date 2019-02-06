package leetcode;

/**
 *  Q:  给定一个 n × n 的二维矩阵表示一个图像。将图像顺时针旋转 90 度。
 *      说明：   你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。
 *              请不要使用另一个矩阵来旋转图像。
 *
 *  A: 顺时针旋转90度可以分解为两部分： 1.  沿着左对角线交换两边的数字 2. 沿着竖直中线交换两边的数字
 *
 * @author kaikanwu
 * @date 15/01/2019
 */
public class Q48_RotateImage {
    /**
     * Time: O(n^2)
     * Space: O(1)
     */
    public void rotate(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        int n = matrix.length;
        // 左对角线交换
        for (int i = 0; i <n ; i++) {

            for (int j = i; j < n; j++) {
                //交换两个坐标上的值
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }

        }
        // 中线翻转交换
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}
