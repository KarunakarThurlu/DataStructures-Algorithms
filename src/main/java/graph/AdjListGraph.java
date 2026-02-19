package graph;

import java.util.*;

/**
 * Graph implementation using Adjacency List representation.
 *
 * - Supports undirected graph
 * - Provides BFS and DFS (iterative)
 *
 * Space Complexity:
 *      O(V + E)
 *
 * Time Complexity:
 *      addEdge() → O(1)
 *      BFS / DFS → O(V + E)
 */
public class AdjListGraph {

    /** Number of vertices */
    private final int vertexCount;

    /** Adjacency list representation */
    private final List<Integer>[] adjacencyList;

    /**
     * Constructs a graph with specified number of vertices.
     *
     * @param vertexCount total number of vertices
     */
    @SuppressWarnings("unchecked")
    public AdjListGraph(int vertexCount) {
        if (vertexCount <= 0) {
            throw new IllegalArgumentException("Vertex count must be positive");
        }

        this.vertexCount = vertexCount;
        this.adjacencyList = new ArrayList[vertexCount];

        for (int i = 0; i < vertexCount; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    /**
     * Adds an undirected edge between source and destination.
     *
     * @param source      starting vertex
     * @param destination ending vertex
     */
    public void addEdge(int source, int destination) {
        validateVertex(source);
        validateVertex(destination);

        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source);
    }

    /**
     * Performs Breadth-First Search traversal.
     *
     * @param startVertex starting vertex
     * @return list of vertices in BFS order
     */
    public List<Integer> bfs(int startVertex) {
        validateVertex(startVertex);

        List<Integer> traversalOrder = new ArrayList<>();
        boolean[] visited = new boolean[vertexCount];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(startVertex);
        visited[startVertex] = true;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            traversalOrder.add(currentVertex);

            for (int neighbor : adjacencyList[currentVertex]) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return traversalOrder;
    }

    /**
     * Performs Depth-First Search traversal (Iterative).
     *
     * @param startVertex starting vertex
     * @return list of vertices in DFS order
     */
    public List<Integer> dfs(int startVertex) {
        validateVertex(startVertex);

        List<Integer> traversalOrder = new ArrayList<>();
        boolean[] visited = new boolean[vertexCount];

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(startVertex);
        visited[startVertex] = true;

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            traversalOrder.add(currentVertex);

            // Reverse iteration to maintain natural order
            List<Integer> neighbors = adjacencyList[currentVertex];
            for (int i = neighbors.size() - 1; i >= 0; i--) {
                int neighbor = neighbors.get(i);
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return traversalOrder;
    }

    /**
     * Validates whether vertex index is within bounds.
     */
    private void validateVertex(int vertex) {
        if (vertex < 0 || vertex >= vertexCount) {
            throw new IllegalArgumentException("Invalid vertex index: " + vertex);
        }
    }
}
