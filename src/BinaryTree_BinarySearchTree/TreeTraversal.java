package BinaryTree_BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * project: Test
 *
 * @author YubaiTao on 07/10/2017.
 *
 * Binary tree traversal in recursive way.
 *
 */
public class TreeTraversal {
    private List<Integer> inOrderResult;
    private List<Integer> preOrderResult;
    private List<Integer> postOrderResult;
    public TreeTraversal() {
        inOrderResult = new ArrayList<>();
        preOrderResult = new ArrayList<>();
        postOrderResult = new ArrayList<>();
        test();
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        inOrderResult.add(root.key);
        inOrder(root.right);
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrderResult.add(root.key);
        preOrder(root.left);
        preOrder(root.right);
    }

    private void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        postOrderResult.add(root.key);
    }

    private void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(11);

        inOrder(root);
        preOrder(root);
        postOrder(root);

        int i = 0;
        System.out.println("In-order result:");
        while (i < 6) {
            System.out.print(" " + inOrderResult.get(i));
            i++;
        }
        System.out.println("\nPre-order result:");
        i = 0;
        while (i < 6) {
            System.out.print(" " + preOrderResult.get(i));
            i++;
        }
        System.out.println("\nPost-order result:");
        i = 0;
        while (i < 6) {
            System.out.print(" " + postOrderResult.get(i));
            i++;
        }
    }
}
