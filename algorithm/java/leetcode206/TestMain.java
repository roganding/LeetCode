package leetcode206;

public class TestMain {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode x = Solution2.reverseList(n1);
        System.out.println(x);
    }

}