package pointToOffer;

/**
 *  Q: 左旋转字符串
 *  把输入字符的前面 k 个字符转移到字符串的尾部
 *
 *  "abcXYZdef", k =3 -> "XYZdefabc"
 *
 * @author kaikanwu
 * @date 22/11/2018
 */
public class P286_LeftRotateString {

    public String LeftRotateString(String str, int n) {
        if (n >= str.length()){
            return str;
        }

        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j){
            swap(chars, i++, j--);
        }

    }

    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }

}
