/**
 * <code>easy</code>
 * Integer Reverse 整数反转
 * 32位的有符号整数  范围：[-2^31 , 2^31 -1]
 */
public class No7 {

    public static int reverse01(int x) {
        if (x == 0) {
            return 0;
        }
        if (x > 0) {
            int[] array = new int[] {-1,-1,-1,-1,-1, -1,-1,-1,-1,-1 };
            int max_pow = 0;
            for (int i = 0; i < array.length; i++) {
                if (x < 10) {
                    array[i] = x;
                    max_pow = i;
                    break;
                }
                array[i] = x % 10;
                x = x / 10;
            }
            int sum = 0;
            for (int i = 0; i <= max_pow; i++ ) {
                if (sum >= Integer.MAX_VALUE) { // 溢出返回0
                    return 0;
                }
                int j = array[i];
                if (j == 0) {
                    continue;
                }
                sum += j * Math.pow(10, max_pow - i);
            }
            return sum;
        } else {
            if (x == Integer.MIN_VALUE) {
                return 0;
            }
            return -reverse01(-x);
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse01(Integer.MAX_VALUE));
        System.out.println(reverse01(-2147483648));
        System.out.println(reverse01(9990000));
    }
}
