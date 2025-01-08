package leetcode136;

/**
 * 一个数组只有一个数字出现了一次，其他数字都出现了2次。
 * 请找出这个数。
 * @author rogan
 * @date 2025/1/8
 */
public class Solution1 {

    public int singleNumber(int[] nums) {
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }


}