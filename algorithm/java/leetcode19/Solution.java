package leetcode19;

/**
 * 删除链表的倒数第n个节点
 *
 * 思路：
 * @author rogan
 * @date 2025/4/14 17:52
 */
public class Solution {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        ListNode delPreNode = head;
        int k = 0;
        while (current != null) {
            if (k > n) {
                delPreNode = delPreNode.next;
            }
            current = current.next;
            k++;
        }
        if (n == k) {
            return head.next;
        }

        ListNode delNode = delPreNode.next;
        if (delNode == null) {
            return null;
        }
        delPreNode.next = delNode.next;
        return head;
    }

    public static void main(String[] args) {
        {
            ListNode n5 = new ListNode(5);
            ListNode n4 = new ListNode(4, n5);
            ListNode n3 = new ListNode(3, n4);
            ListNode n2 = new ListNode(2, null);
            ListNode head = new ListNode(1, n2);

            ListNode listNode = removeNthFromEnd(head, 1);
            System.out.println(listNode);
        }

    }

}