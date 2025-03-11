package leetcode94;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代解法
 * @author rogan
 * @date 2025/3/11
 */
public class Solution2 {

    /**
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return ;
        }

        inorder(root.left, result);

        result.add(root.val);

        inorder(root.right, result);
    }

}