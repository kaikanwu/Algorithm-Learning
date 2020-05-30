package leetcode;

/**
 * @author kaikanwu
 * created on 5/30/2020
 */
public class Q796_RotateString {

    public boolean rotateString(String A, String B) {

        // 处理边界情况
        if (A.isEmpty() && B.isEmpty()) {
            return true;
        }
        if (A.length() != B.length()) {
            return false;
        }


        int i = 0;
        int j = 0 ;

        while (j < B.length() && i < A.length()) {
            if (A.charAt(i) == B.charAt(j)) {

                i++;
                j++;
            }else {
                i++;
            }

            if (i == A.length()) {
                i = 0;
                if (A.charAt(i) != B.charAt(j)) {
                    return false;
                }
            }
        }

        return true;


    }


}
