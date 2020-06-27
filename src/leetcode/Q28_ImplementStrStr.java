package leetcode;

/**
 * @author kaikanwu
 * created on 6/27/2020
 */
public class Q28_ImplementStrStr {


    /**
     * Time: O((n-m+1)*m)
     * Space: O(1)
     */
    public int strStr(String haystack, String needle) {

        if (haystack == null || needle == null) {
            return -1;
        }

        if (needle.length() == 0) {
            return 0;
        }


        int n = haystack.length();
        int m = needle.length();


        for (int i = 0; i <= n - m; ++i) {
            int j = 0;
            int k = i;

            for (; j < m && k < n && needle.charAt(j) == haystack.charAt(k); ++j, ++k) {

            }
            if (j == needle.length()) {
                return i;
            }


        }

        return -1;
    }


}
