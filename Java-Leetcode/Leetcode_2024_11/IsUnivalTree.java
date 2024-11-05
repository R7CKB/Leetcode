import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Title: IsUnivalTree
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/5 09:55
 * Description: Leetcode 965 easy
 */
public class IsUnivalTree {
    //Definition for a binary tree node.
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

    // 递归实现
//    public boolean isUnivalTree(TreeNode root) {
//        if (root == null) return true;
//        if (root.left != null && root.left.val != root.val) return false;
//        if (root.right != null && root.right.val != root.val) return false;
//        return isUnivalTree(root.left) && isUnivalTree(root.right);
//    }

    // 三叶的递归实现,更加简洁一点
//    int val = -1;
//
//    public boolean isUnivalTree(TreeNode root) {
//        if (val == -1) val = root.val;
//        if (root == null) return true;
//        if (root.val != val) return false;
//        return isUnivalTree(root.left) && isUnivalTree(root.right);
//    }

    // 迭代的方式实现层序遍历
    public boolean isUnivalTree(TreeNode root) {
        int val = root.val;
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);
        while (!d.isEmpty()) {
            TreeNode poll = d.pollFirst();
            if (poll.val != val) return false;
            if (poll.left != null) d.addLast(poll.left);
            if (poll.right != null) d.addLast(poll.right);
        }
        return true;
    }


}
