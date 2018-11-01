package pointToOffer;

/**
 *  Q. 表示数值的字符串
 *
 *  请实现一个函数用来判断字符串是否表示数值（包括整数和小数）
 *
 * @author kaikanwu
 * @date 01/11/2018
 */
public class P127_NumberStrings {


    public boolean isNumeric(char[] str) {

        if (str == null || str.length == 0) {
            return false;
        }

        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");


    }
}
