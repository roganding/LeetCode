package leetcode206;

/**
 * 递归解法.
 * 调试了好几遍，花费时间较多
 * @author rogan
 * @date 2024/12/29
 */
public class Solution2 {

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;

        head.next = null;// head 赋值null，无需在reverseList之后
        ListNode newHead = reverseList(next);

        next.next = head;
        return newHead;
    }

}