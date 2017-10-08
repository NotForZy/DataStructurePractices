package BinaryTree_BinarySearchTree;

/**
 * @author YubaiTao on 03/09/2017.
 * @project Test
 */
public class IsBST {
    public IsBST() {
        test();
    }

    // Judge whether a binary tree is a BSTr
    public boolean isBST(TreeNode root) {
        return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBSTHelper(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.key <= min || root.key >= max) {
            return false;
        }
        return isBSTHelper(root.left, min, root.key)
                && isBSTHelper(root.right, root.key, max);
    }

    private void test() {

    }
}

class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int key) {
        this.key = key;
    }
}
