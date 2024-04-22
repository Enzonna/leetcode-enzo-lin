package leetcode.treecode;

/**
 * Package: leetcode.treecode
 * Description: Definition for a binary tree node.
 *
 * @Author ENZO
 * @Create 2024年4月22日 09:16
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
