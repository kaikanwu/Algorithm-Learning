package leetcode;

/**
 *  Q:  编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *      每行的元素从左到右升序排列。
 *      每列的元素从上到下升序排列。
 *
 *  A:  根据给出的二维矩阵的特性，我们可以从右上角的数字（或者左下角的数字）开始做比较。
 *
 * @author kaikanwu
 * @date 12/01/2019
 */
public class Q240_SearchA2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        // 判断输入是否为空
        if (matrix == null ||matrix.length == 0) {
            return false;
        }

        int i = 0;
        int j = matrix[0].length - 1;

        while (i<= matrix.length-1 && j>=0){
            if (matrix[i][j]< target){
                i++;
            }
            else if (matrix[i][j] > target) {
                j--;
            }
            else {
                return true;
            }
        }
        return false;
    }


}
