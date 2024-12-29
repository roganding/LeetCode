package leetcode206;

/**
 * @author rogan
 * @date 2024/12/29
 */
public class Solution1 {

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode headNext = head.next;// 取下一个
        head.next = null;// 赋值next为空
        while (headNext != null) {
            ListNode tmpNext = headNext.next;

            headNext.next = head;

            head = headNext;
            headNext = tmpNext;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode x = reverseList(n1);
        System.out.println(x);
    }
}