package leetcode09;

/**
 * 是否回文数字
 * @author rogan
 * @date 2024/12/30
 */
public class Solution1 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;// 所有负数都不是回文数
        }
        if (x == 0) {
            return true;
        }

        int[] array = new int[16];
        int count = 0;
        while (x > 0) {
            array[count] = x % 10;
            count++;
            x = x / 10;
        }

        int half = count / 2 + 1;

        for (int i = 0; i < half - 1; i++) {
            if (array[i] != array[count - i - 1]) {
                return false;
            }
        }

        return true;
    }
}