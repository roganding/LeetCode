package leetcode09;

public class TestMain {

    public static void main(String[] args) {
        Solution1 s = new Solution1();

        s.isPalindrome(1001);
        assert !s.isPalindrome(123);
    }
}