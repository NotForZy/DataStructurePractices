package BinaryTree_BinarySearchTree;

/**
 * project: Test
 *
 * @author YubaiTao on 07/10/2017.
 */
public class IterativeTreeTraversal {
    public IterativeTreeTraversal() {
        test();
    }




    private void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(11);
    }
}
