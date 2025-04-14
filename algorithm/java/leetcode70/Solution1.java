package leetcode70;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯
 * @author rogan
 * @date 2024/12/30
 */
public class Solution1 {

    private static Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 1) {
            map.put(1,1);
            return 1;
        }
        if (n == 2) {
            map.put(2, 2);
            return 2;
        }

        int res = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(n, res);

        return res;
    }
}