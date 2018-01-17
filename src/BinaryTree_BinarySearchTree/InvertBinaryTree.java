package BinaryTree_BinarySearchTree;

public class InvertBinaryTree {
    public InvertBinaryTree() {
        test();
    }

    private TreeNode swap(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = swap(root.left);
        TreeNode right = swap(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    private void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(11);

        IterativeTreeTraversal.preOrder(root);
        System.out.println();
        IterativeTreeTraversal.preOrder(swap(root));
    }
}
