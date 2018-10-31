package pointToOffer;

/**
 *  Q: 矩阵中的路径
 *  设计一个函数，用来判断一个矩阵中是否存在一条包含某字符串的路径。
 *  1. 起点随意 2. 路径的移动只能是上下左右 3. 访问过的位置不能再访问
 *
 *  A：使用回溯法解决这个问题
 *
 *
 * @author kaikanwu
 * @date 31/10/2018
 */
public class P89_StringPathInMatrix {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        //参数校验
        if (matrix == null || matrix.length != rows*cols|| str == null || str.length <1) {
            return false;
        }


        //变量初始化
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        //记录结果的数组
        int[] pathLength = {0};
        //以每一个点为起始进行搜索
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, rows, cols, str, visited, i, j, pathLength)) {
                    return true;
                }

            }
        }
        return false;
    }

    /**
     * 回溯搜索算法
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @param visited
     * @param row
     * @param col
     * @param pathLength
     * @return
     */
    private static boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, boolean[] visited, int row, int col, int[] pathLength) {

        if (pathLength[0] == str.length) {
            return true;
        }

        boolean hasPath = false;

        // 判断位置是否合法
        if (row >= 0 && row < rows
                && col >= 0 && col < cols
                && matrix[row * cols + col] == str[pathLength[0]]
                && !visited[row * cols + col]){
            visited[row * cols + col ] = true;
            pathLength[0]++;

            // 按左上右下进行回溯
            hasPath = hasPathCore(matrix, rows, cols, str, visited, row, col - 1, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row - 1, col, pathLength)
                    || hasPathCore(matrix,rows, cols, str, visited, row, col + 1, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited,row + 1, col, pathLength);


            if (!hasPath) {
                pathLength[0]--;
                visited[row * cols + col] =  false;
            }

        }
        return hasPath;


    }


}
