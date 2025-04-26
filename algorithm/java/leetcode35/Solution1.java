package leetcode35;

/**
 * 有序数组中，找到该数的索引下标
 * @author rogan
 * @date 2025/4/14 23:17
 */
public class Solution1 {

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (nums[0] > target) {
            return 0;
        }
        // 快速失败
        if (nums[len - 1] < target) {
            return len;
        }

        int left = 0;
        int right = len - 1;
        while (left <= right) {

            int mid = (left + right) / 2;
            // 找到target 元素
            if (nums[mid] == target) {
                return mid;
            }

            // 如果 mid 比 target 大，target 可能在left 到 mid 范围内
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        {
            int[] ints = {1, 3};
            System.out.println(searchInsert(ints, 3));
        }
        {
            int[] ints = {1, 3, 5, 6};
            System.out.println(searchInsert(ints, 5));
            // 2
            System.out.println(searchInsert(ints, 2));
            // 1
            System.out.println(searchInsert(ints, 7));
            // 4
        }
        {
            int[] ints = {1, 3, 5, 7, 10};
            System.out.println(searchInsert(ints, 8));
        }
        {
            int[] ints = {1};
            System.out.println(searchInsert(ints, 1));
        }
    }
}