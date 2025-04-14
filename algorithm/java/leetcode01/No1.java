package leetcode01;

/**
 * Easy
 * 两数之和，给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class No1 {

    /**
     * 仍然是 O(n2)的复杂度
     * 需要 借助 HashMap 降低
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[] {-1, -1};

        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            for (int j = 0; j < i ; j++) {
                if (tmp[j] == num) {
                    return new int[] {i, j};
                }
            }
            tmp[i] = target - num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] res = twoSum(new int[]{1,4,0,0,3,-1}, 0);
        System.out.println(res[0] + " " + res[1]);
    }
}