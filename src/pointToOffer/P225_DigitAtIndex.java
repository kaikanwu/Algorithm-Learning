package pointToOffer;

/**
 *  Q: 数字序列中某一位的数字
 *  数字以 0123456789101112131415... 的格式序列化到一个字符序列中。
 *  在这个序列中，第5位（从 0 开始计数）是5，第13位是1，第19位是4，等等。
 *  请写一个函数，求任意第 n 位对应的数字。
 *
 *  A：详见P225，与43题相似，都是找数学规律。
 *  如果使用简单的遍历，会导致复杂度很高，所以应该寻找其规律，按照规律解题。
 *
 *
 * @author kaikanwu
 * @date 21/11/2018
 */
public class P225_DigitAtIndex {

    public static int digitAtIndex(int index) {

        if (index < 0) {
            return -1;
        }
        if (index < 10) {
            return index;
        }

        int curIndex = 10;
        int length = 2;
        int boundNum = 10;
        while ((curIndex + lengthSum(length)) < index) {
            curIndex += lengthSum(length);
            boundNum *= 10;
            length++;
        }

        int addNum = (index - curIndex) / length;
        int curNum = boundNum + addNum;
        return Integer.toString(curNum).charAt(index - curIndex - addNum * length) - '0';



    }


    private static int lengthSum(int length) {

        int count = 9 ;
        for (int i = 1; i < length; i++) {
            count *= 10;
        }

        return count * length;
    }


    /**
     * for test
     * @param args
     */
    public static void main(String[] args) {


        System.out.println(digitAtIndex(21));

    }

}
