package leetcode;

import java.util.HashMap;

/**
 *  Q:  判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *      数字 1-9 在每一行只能出现一次。
 *      数字 1-9 在每一列只能出现一次。
 *      数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 *  A:  这题不太懂，所以参考了官方题解：https://leetcode-cn.com/articles/valid-sudoku/
 *
 * @author kaikanwu
 * @date 15/01/2019
 */
public class Q36_ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        // init data
        HashMap<Integer, Integer> [] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    // 用来计算该坐标位于哪个子数独块中
                    int boxIndex = (i / 3 ) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[boxIndex].put(n, boxes[boxIndex].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[boxIndex].get(n) > 1){
                        return false;
                    }

                }
            }
        }

        return true;

    }
}
