package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * project: Test
 *
 * @author YubaiTao on 08/10/2017.
 *
 * Get the list of list of keys in a given binary tree layer by layer.
 * Each layer is represented by a list of keys and the keys are traversed from left to right.
 *
 */
public class TraverseLayerByLayer {
    public TraverseLayerByLayer() {
        test();
    }

    // Breadth First Search
    private List<List<Integer>> BFS(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode> ();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // the list storing all the nodes on the current level.
            List<Integer> curLayer = new ArrayList<>();
            // the size of the current level.
            int size = queue.size();
            // traverse all the nodes on the current level and
            // prepare for the next level.
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                curLayer.add(cur.key);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            list.add(curLayer);
        }

        return list;
    }

    private void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.right.right.left = new TreeNode(15);

        List<List<Integer>> result = new ArrayList<>();
        result = BFS(root);

        for (int i = 0;  i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
