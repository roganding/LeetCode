package leetcode121;

/**
 * 买卖股票最佳时机
 *
 * @author rogan
 * @date 2025/4/12
 */
public class Solution1 {

    /**
     * 找到数组中 升序的子数组，再找出其中最大差值的就是买卖利润最大的结果
     * @param prices 长度最多10w，数值范围 0~1w
     * @return
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;

        int minPrice = prices[0];// 第i天的最小价格

        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            if (price < minPrice) {
                // 最小值更换
                minPrice = price;
                continue;
            }

            // 第i天的利润
            int currentProfit = price - minPrice;
            maxProfit = Math.max(maxProfit, currentProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {3,2,6,5,0,3}));
        // 4

        System.out.println(maxProfit(new int[] {1, 4, 2}));
        // 3

        System.out.println(maxProfit(new int[] {2, 4, 6, 9}));
        // 7

        System.out.println(maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
        // 5

        System.out.println(maxProfit(new int[] {7, 6, 4, 1}));
        // 0
    }
}