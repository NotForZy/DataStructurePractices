package BinaryTree_BinarySearchTree;

import Stack_Queue_LinkedList.DeleteNodeBackward;

import java.util.*;

/**
 * project: Test
 *
 * @author YubaiTao on 07/10/2017.
 *
 */
public class IterativeTreeTraversal {
    public IterativeTreeTraversal() {
        test();
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }
            System.out.print(cur.key + " ");
        }
    }

    private void inOrder(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            } else {
                cur = stack.pollFirst();
                System.out.print(cur.key + " ");
                cur = cur.right;
            }
        }
    }

    // Implementation with two stacks.
    private void postOrder(TreeNode root) {
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        TreeNode cur = root;
        stack1.offerFirst(cur);
        while(!stack1.isEmpty()) {
            cur = stack1.pollFirst();
            if(cur.left != null) {
                stack1.offerFirst(cur.left);
            }
            if (cur.right != null) {
                stack1.offerFirst(cur.right);
            }
            stack2.offerFirst(cur);
        }
        while(!stack2.isEmpty()) {
            System.out.print(stack2.pollFirst().key + " ");
        }
    }

    private void postOrder2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        do {
            while (root != null) {
                if (root.right != null) {
                    stack.offerFirst(root.right);
                }
                stack.offerFirst(root);
                root = root.left;
            }

            root = stack.pollFirst();

            if (root.right != null && stack.peek() == root.right) {
                stack.pollFirst();
                stack.offerFirst(root);
                root = root.right;
            } else {
                System.out.print(root.key + " ");
                root = null;
            }
        } while (!stack.isEmpty());
    }


    private void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(11);

        System.out.println("PreOrder: ");
        preOrder(root);
        System.out.println("\nInOrder: ");
        inOrder(root);
        System.out.println("\nPostOrder: ");
        postOrder(root);
        System.out.println("\nPostOrder2: ");
        postOrder2(root);
    }
}
