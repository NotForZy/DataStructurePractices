package BinaryTree_BinarySearchTree;

/**
 * @author YubaiTao on 03/09/2017.
 * @project Test
 */
public class BinaryTree {
    public BinaryTree() {

    }

    // Judge whether a binary tree is a BST
    public boolean isBST(TreeNode root) {
        return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBSTHelper(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.value <= min || root.value >= max) {
            return false;
        }
        return isBSTHelper(root.left, min, root.value)
                && isBSTHelper(root.right, root.value, max);
    }

    public TreeNode testTreeConstrunction(int[] array) {
        return null;
    }
}

class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int value) {
        this.value = value;
    }
}
