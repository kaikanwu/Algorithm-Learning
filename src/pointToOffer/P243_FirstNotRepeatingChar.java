package pointToOffer;

/**
 *  Q: 第一次只出现一次的字符。
 *  例如："abaccdeff"， 则输出 'b',或者该字符的位置
 *
 * @author kaikanwu
 * @date 22/11/2018
 */
public class P243_FirstNotRepeatingChar {


    /**
     *  最直观的解法，是使用 HashMap 对出现的次数进行统计，但是考虑到要统计的字符范围有限，
     *  因此可以使用整型数组代替 HashMap
     * @param str
     * @return
     */
    public int firstNotRepeatingChar(String str) {

        // 2的8次 256
        int[] count = new int[256];

        for (int i = 0; i < str.length(); i++) {

            count[str.charAt(i)]++;
        }

        for (int i = 0; i <str.length() ; i++) {
            if (count[str.charAt(i)] == 1) {
                return i;
            }
        }

        return -1;
    }




}
