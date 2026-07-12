/**
 * Depth-First Search (DFS) is like exploring a maze. You pick a path, follow it as deep as it goes until you hit a dead end, and then you backtrack to the last intersection to try the next available path.
 *
 * Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges. You visit every node exactly once and inspect every edge exactly once.
 * Space Complexity: O(V) in the worst case. This accounts for the HashSet storing up to V nodes, and the memory used by the recursive call stack if the graph is completely linear (like a linked list).
 */


public class DFS {
    public void dfs( Map<Integer, List<Integer>> graph, int start){
        Set<Integer> stack = new HashSet<>();
        dfsHelper(graph, start, stack);
    }

    public void dfsHelper(Map<Integer, List<Integer>> graph, int currentNode, Set<Integer> visited){

        // Process the node (e.g., print it, add to a result list)
        System.out.println( start );
        // 1. Mark the current node as visited
        visited.add(currentNode);

        // 2. Retrieve neighbors, defaulting to an empty list to avoid NullPointerExceptions
        List<Integer> neighbors = graph.getOrDefault(currentNode, new ArrayList<>());

        // 3. Recursively visit all unvisited neighbors
        for(int neighbor : neighbors){
            if(!visited.contains(neighbor)){
                dfsHelper(graph, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        // 1. Initialize the adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // 2. Build the graph edges
        // Visualizing the graph:
        //       0
        //      / \
        //     1   2
        //    / \   \
        //   3   4   5

        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(3, 4));
        graph.put(2, Arrays.asList(5));

        // Nodes 3, 4, and 5 have no outbound edges,
        // so we don't strictly need to add them to the map
        // because getOrDefault handles nulls, but adding them is good practice.
        graph.put(3, new ArrayList<>());
        graph.put(4, new ArrayList<>());
        graph.put(5, new ArrayList<>());

        // 3. Execute DFS
        DFS runner = new DFS();
        System.out.print("DFS Traversal Output: ");
        runner.dfs(graph, 0);

        // Expected Output: 0 1 3 4 2 5
    }
}