package BFS;

import java.util.*;

/**
 * project: Test
 *
 * @author YubaiTao on 19/10/2017.
 */
public class Bipartite {
    public Bipartite() {
        test();
    }

    private boolean isBipartite(List<GraphNode> graph) {
        // use 0 and 1 to denote two different groups.
        // the map maintains for each node which group it belongs to.
        HashMap<GraphNode, Integer> visited = new HashMap<>();
        // the graph can be presented by a list of nodes
        // (if it is not guaranteed to be connected).
        // we have to do BFS from each of the nodes.
        for (GraphNode node : graph) {
            if (!BFS(node, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean BFS(GraphNode node, HashMap<GraphNode, Integer> visited) {
        if (visited.containsKey(node)) {
            return true;
        }
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(node);
        // start breadth-first-search from the node,
        // since the node has not been visited,
        // we can assign it to any of the groups, for example, group 0
        visited.put(node, 0);
        while (!queue.isEmpty()) {
            GraphNode cur = queue.poll();
            // the group assigned for cur node
            int curGroup = visited.get(cur);
            // the group assigned for any neighbor of cur node
            int neiGroup = curGroup == 0 ? 1 : 0;
            for (GraphNode nei : cur.neighbors) {
                // if the neighbor has not been visited,
                // just put it in the queue and choose the correct group
                if (!visited.containsKey(nei)) {
                    visited.put(nei, neiGroup);
                    queue.offer(nei);
                } else if (visited.get(nei) != neiGroup) {
                    // only if the neighbor has been traversed and the group does not
                    // match to the desired one, return false.
                    return false;
                }
                // if the neighbor has been traversed and the group matches the
                // desired one, we do not need to do anything.
            }
        }
        return true;
    }

    private void test() {

    }
}

class GraphNode {
    public int key;
    public List<GraphNode> neighbors;
    public GraphNode(int key) {
        this.key = key;
        this.neighbors = new ArrayList<GraphNode>();
    }
}
