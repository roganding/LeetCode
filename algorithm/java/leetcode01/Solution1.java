package leetcode01;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rogan
 * @date 2025/1/8
 */
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int b = target - a;
            if (map.containsKey(b)) {
                return new int[] {i, map.get(b)};
            }
            map.put(a, i);
        }
        return null;
    }


}