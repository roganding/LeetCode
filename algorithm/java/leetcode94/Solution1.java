package leetcode94;


import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 *
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。(顺序从左往右：左节点，根节点，右节点)
 * @author rogan
 * @date 2025/3/11
 */
public class Solution1 {


    private List<Integer> result = new ArrayList<>();
    /**
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        }

        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
        return result;
    }

}