/**
 * The complexity is exactly the same as DFS, just processed in a different order.
 * Time Complexity: O(V + E) where V is the number of vertices (nodes) and E is the number of edges. We still visit every node and check every edge once.
 * Space Complexity: O(V). In the worst-case scenario (like a star-shaped graph where one node is connected to everything else), the queue will need to hold almost all the vertices at the same time.
 */

import java.util.*;

class GraphBFS {

    public void bfs(Map<Integer, List<Integer>> graph, int startNode) {
        // 1. We need a Queue to keep track of what to visit next
        Queue<Integer> queue = new LinkedList<>();
        // 2. We need a Set to keep track of where we have already been
        Set<Integer> visited = new HashSet<>();

        // 3. Start by adding the first node to both
        queue.offer(startNode);
        visited.add(startNode);

        // 4. Keep exploring as long as there is someone in line
        while (!queue.isEmpty()) {
            // Take the node at the front of the line
            int currentNode = queue.poll();

            // Process the node
            System.out.print(currentNode + " ");

            // Look at all of its neighbors
            List<Integer> neighbors = graph.getOrDefault(currentNode, new ArrayList<>());

            for (int neighbor : neighbors) {
                // If we haven't visited this neighbor yet...
                if (!visited.contains(neighbor)) {
                    // Mark it as visited immediately!
                    visited.add(neighbor);
                    // Get them in line to be processed later
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Visualizing the same graph from before:
        //       0
        //      / \
        //     1   2
        //    / \   \
        //   3   4   5

        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(3, 4));
        graph.put(2, Arrays.asList(5));

        GraphBFS runner = new GraphBFS();
        System.out.print("BFS Traversal Output: ");
        runner.bfs(graph, 0);

        // Expected Output: 0 1 2 3 4 5
        // Notice how it prints all level 1 nodes (1, 2) before level 2 nodes (3, 4, 5)!
    }
}