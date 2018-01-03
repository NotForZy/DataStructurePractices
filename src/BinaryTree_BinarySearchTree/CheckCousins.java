package BinaryTree_BinarySearchTree;

/*
 * Check if two nodes are cousins in a Binary Tree.
 *
 * Given the binary tree and the two nodes say 'a' and 'b',
 * determine whether the two nodes are cousins of each other or not.
 * Two nodes are cousins of each other if they are at the same level and have different parents.
 *
 * Example:
 *           6
 *        /    \
 *       3      5
 *      / \   /  \
 *     7  8  1   2
 *
 * 7 and 1, result is TRUE.
 * 3 and 5, result is FALSE.
 * 7 and 5, result is FALSE.
 *
 */


import java.util.LinkedList;
import java.util.Queue;

public class CheckCousins {

    private boolean areCousins = false;

    public CheckCousins() {
        test();
    }

    // Method 0: getHeight() and check parent
    private boolean ifCousins(TreeNode root, TreeNode a, TreeNode b) {
        return (getHeight(root, a, 0) == getHeight(root, b, 0)) &&
                !isSibling(root, a, b);
    }

    private int getHeight(TreeNode root, TreeNode target, int height) {
        if (root == target) {
            return height;
        }
        if (root.left == null && root.right == null) {
            return -1;
        }
        int left = getHeight(root.left, target, height + 1);
        int right = getHeight(root.right, target, height + 1);
        return left > right? left:right;
    }

    private boolean isSibling(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return false;
        }
        if ( (root.left == a && root.right == b) ||
                (root.left == b && root.right == a) ) {
            return true;
        }
        return isSibling(root.left, a, b) || isSibling(root.right, a, b);
    }

    // Method 1: BFS
    private boolean BFS(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || a == null || b == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left == a || curr.right == a ||
                        curr.left == b || curr.right == b) {
                    if (!flag) {
                        flag = true;
                    } else {
                        // Both two nodes show up at current level,
                        // return true.
                        // They are not siblings because this case
                        // is checked when the first node shows up.
                        return true;
                    }
                    if ( (curr.left == a && curr.right ==b) ||
                            (curr.left == b && curr.right == a)) {
                        return false;
                    }
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            // If only one node shows up at this level,
            // return false.
            if (flag) {
                return false;
            }
        }
        return false;
    }

    // Method 2: DFS
    private boolean DFS(TreeNode root, TreeNode a, TreeNode b) {
        IsCousin(root, a, b, 0);
        return areCousins;
    }

    private int IsCousin(TreeNode root, TreeNode a, TreeNode b, int level) {
        if (root == null) {
            return -1;
        }
        if (root == a || root == b) {
            return level;
        }

        int left = IsCousin(root.left, a, b, level + 1);
        int right = IsCousin(root.right, a, b, level + 1);

        if (left == right && left - 1 > level) {
            areCousins = true;
        }

        return left > right ? left : right;
    }




    private void test() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(2);

        TreeNode a = root.left.left;
        TreeNode b = root.right.right;

        boolean result0 = ifCousins(root, a, b);
        System.out.println("----- BFS -----");
        System.out.println("Are the nodes with value " + a.key + " and " + b.key + " cousins?");
        System.out.println(result0?"    Yes.":"    No.");
        System.out.println();

        boolean result1 = BFS(root, a, b);
        System.out.println("----- BFS -----");
        System.out.println("Are the nodes with value " + a.key + " and " + b.key + " cousins?");
        System.out.println(result1?"    Yes.":"    No.");
        System.out.println();

        boolean result2 = DFS(root, a, b);
        System.out.println("----- DFS -----");
        System.out.println("Are the nodes with value " + a.key + " and " + b.key + " cousins?");
        System.out.println(result2?"    Yes.":"    No.");
    }
}
