package leetcode287;

/**
 * 数组长度 n+1
 * 数组元素的范围：1到n
 * 找出数组中重复的数字
 *
 * 有点难
 * @author rogan
 * @date 2025/1/8
 */
public class Solution1 {

    /**
     * 利用环形链表，快慢指针重逢的特性解题
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];

        } while (slow != fast);

        // 上一步只能是找到个环形链表
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}