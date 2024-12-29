package leetcode104;

/**
 * 二叉树的最大深度
 * @author rogan
 * @date 2024/12/29
 */
public class Solution1 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}