package pointToOffer;

/**
 * 题目：替换空格
 * 把输入字符串的空格替换为 "%20"， 并且让传入数组保证有足够空间容纳修改后的字符串
 */
public class P51_ReplaceSpaces {



    /**
     *
     *  由于java的字符串数组没有结束符，所以需要多传入个原始长度
     *  先计算好替换后的位置，从后向前替换，时间复杂度O（n）
     * @param data
     * @param length
     */
    public static void replaceBlank(char[] data, int length) {

        int newLength = length;
        for (int i = 0; i < length; i++) {
            //如果传入的是空格，则修改新字符串的长度
            if (data[i] == ' ') {
                newLength += 2;
            }
        }

        for (int indexOfOld = length - 1, indexOfNew = newLength - 1; indexOfOld >= 0 && indexOfOld != indexOfNew; indexOfOld--, indexOfNew--) {

            if (data[indexOfOld] == ' ') {
                data[indexOfNew--] = '0';
                data[indexOfNew--] = '2';
                data[indexOfNew] = '%';

            } else {
                data[indexOfNew] = data[indexOfOld];
            }
        }



    }


    public static void main(String[] args) {
        char[] predata = "we are happy".toCharArray();
        char[] data = new char[20];

        for (int i = 0; i < predata.length; i++) {
            data[i] = predata[i];

        }

        System.out.println(data);
        replaceBlank(data, 13);
        System.out.println(data);
    }

}
