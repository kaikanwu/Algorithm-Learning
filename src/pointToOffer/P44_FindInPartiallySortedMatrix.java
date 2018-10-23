package pointToOffer;

/**
 * 题目：二维数组中的查找
 *  输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 *
 */
public class P44_FindInPartiallySortedMatrix {
    public static boolean findInPartiallySortedMatrix(int[][] data, int target) {

        if (data == null || data.length == 0 || data[0].length == 0) {
            return false;
        }

        //设定行列的最大值（边界）
        int rowMax = data.length - 1;
        int colMax = data[0].length - 1;

        // 把二维数组理解为矩阵
        // 刚开始时，选定右上角的数
        int rowCur = data.length - 1;
        int colCur = 0;


        while (true) {

            //超过的时候就是没有找到这个数
            if (rowCur < 0 |  colCur < 0 | rowCur > rowMax |colCur > colMax) {
                return false;
            }

            // 如果当前数是target直接返回true
            if (data[rowCur][colCur] == target) {
                return true;
            } else if (data[rowCur][colCur] > target) {
                //当右上角的数大于目标数的时候，
                //删除右上角数的这一列，也就是rowCur -1
                rowCur--;
            }
            else {
                //反之，如果右上角的数小于目标数
                //也就是删除当前这一行，所以row不变，列数+1
                colCur++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] data = {{1,2,8,9}, {2,4,9,12}, {4,6,10,13},{6,8,11,15}};

        System.out.println(findInPartiallySortedMatrix(data, 7));
    }



}
