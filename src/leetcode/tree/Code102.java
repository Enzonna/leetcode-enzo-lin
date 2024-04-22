package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Package: leetcode.treecode
 * Description: level order traversal - Medium
 *
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 *
 * @Author ENZO
 * @Create 2024年4月22日 09:15
 */
public class Code102 {
    /**
     * 每个点进出队各一次，时间复杂度O(n),队中元素个数不超过n，空间复杂度O(n)
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        //队列，存储每一层 树 一层一层向下遍历
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //根进队
        queue.offer(root);

        while (!queue.isEmpty()) {
            //当前层的temp队列
            List<Integer> level = new ArrayList<Integer>();
            //当前层的队列长度，每一次循环该长度都动态变化！！！这是关键
            int currentLevelSize = queue.size();

            for (int i = 1; i <= currentLevelSize; ++i) {
                //队列中头节点出队
                TreeNode node = queue.poll();
                //头节点val进入temp队列，存储这一层的树节点
                level.add(node.val);
                //如果这个节点有左儿子，那么让左儿子进queue队，以便下一层循环的遍历
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            //temp队列入 结果队列
            ret.add(level);
        }

        return ret;
    }

}
