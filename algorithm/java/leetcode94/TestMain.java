package leetcode94;

import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        root.right.right.left = new TreeNode(9);

        {
            Solution1 solution = new Solution1();
            List<Integer> res = solution.inorderTraversal(root);
            System.out.println(res);
        }

        {
            Solution2 solution = new Solution2();
            List<Integer> res = solution.inorderTraversal(root);
            System.out.println(res);
        }
    }
}