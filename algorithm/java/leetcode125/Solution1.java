package leetcode125;

public class Solution1 {

    public boolean isPalindrome(String s) {
        int length = s.length();

        for (int i = 0, j = length -1 ; i <= j;) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if (!isLegalChar(c1)) {
                i++;
                continue;
            }
            if (!isLegalChar(c2)) {
                j--;
                continue;
            }

            if (c1 != c2 && Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private static boolean isLegalChar(char c) {
        return ('0' <= c && '9' >= c) || ('a' <= c && 'z' >= c) || ('A' <= c && 'Z' >= c);
    }
}