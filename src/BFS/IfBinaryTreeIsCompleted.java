package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * project: Test
 *
 * @author YubaiTao on 18/10/2017.
 */
public class IfBinaryTreeIsCompleted {
    public IfBinaryTreeIsCompleted() {
        test();
    }

    // Breadth First Search
    private boolean BFS(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // if the flag is set true, there should not be any child nodes afterwards.
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            //if any of the child is not present, set the flag to true
            if (cur.left == null) {
                flag = true;
            } else if (flag) {
                // if flag is set but we still see cur has a left child,
                // the binary tree is not a completed one
                return false;
            } else {
                // if flag is not set and left child is present
                queue.offer(cur.left);
            }

            if (cur.right == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                queue.offer(cur.right);
            }
        }
        return true;

    }

    private void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(12);
        String result = BFS(root) ? "True" : "False";
        System.out.println("Is current tree a complete tree? " + result);

    }
}
