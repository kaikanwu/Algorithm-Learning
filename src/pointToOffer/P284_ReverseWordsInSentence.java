package pointToOffer;

/**
 *  Q: 翻转字符串
 *  输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 *  为简单起见，标点符号和普通字母一样处理。
 *
 *  例如： "I am a student." -> "student. a am I"
 *
 *
 *  A: 题目的隐藏条件应该是不能使用额外空间。
 *
 *  正确的解法应该是书上的，先旋转每个单词，再旋转字符串。
 *
 *
 * @author kaikanwu
 * @date 22/11/2018
 */
public class P284_ReverseWordsInSentence {



    public String reverseSentences(String str){

        int n = str.length();
        char[] chars = str.toCharArray();
        int i = 0;
        int j = 0;

        while (j <= n) {
            if (j == n || chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j+1;
            }
            j++;
        }

        reverse(chars, 0, n - 1);
        return new String(chars);

    }

    private void reverse(char[] c, int i, int j) {

        while (i < j) {
            swap(c, i++, j--);
        }
    }

    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }


}
