package leetcode200.at.doublePointer;

public class Q345_ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if (s == null ||s.length() == 1) {
            return s;
        }
        int l = 0;
        int r = s.length() - 1;
        // 元音字母： AEIOU
        char[] result = s.toCharArray();
        char[] vowelsChars = new char[]{'a','e','i','o','u','A','E','I','O','U'};
        while (l < r) {
            if (isVowel(vowelsChars, s.charAt(l)) && isVowel(vowelsChars, s.charAt(r))) {
                char temp = result[l];
                result[l] = result[r];
                result[r] = temp;
                l++;
                r--;
            } else if (isVowel(vowelsChars, s.charAt(l)) && !isVowel(vowelsChars, s.charAt(r))) {
                r--;
            } else if (!isVowel(vowelsChars, s.charAt(l)) && isVowel(vowelsChars, s.charAt(r))) {
                l++;
            } else {
                l++;
                r--;
            }
        }

        return String.valueOf(result);

    }

    private boolean isVowel(char[] chars, char target) {
        for (char c : chars) {
            if (c == target) {
                return true;
            }
        }
        return false;
    }
}
