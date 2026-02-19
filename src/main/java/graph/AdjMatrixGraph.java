package graph;

import java.util.*;

/**
 * Graph implementation using Adjacency Matrix representation.
 *
 * - Supports undirected graph
 * - Provides BFS and DFS traversal (iterative)
 *
 * Space Complexity:
 *      O(V²)  → Adjacency Matrix
 *
 * Time Complexity:
 *      addEdge() → O(1)
 *      BFS / DFS → O(V²)
 */
public class AdjMatrixGraph {

    /** Number of vertices in the graph */
    private final int vertexCount;

    /** Number of edges in the graph */
    private int edgeCount;

    /** Adjacency matrix representation */
    private final int[][] adjacencyMatrix;

    /**
     * Creates a graph with given number of vertices.
     *
     * @param vertexCount total vertices in the graph
     */
    public AdjMatrixGraph(int vertexCount) {
        this.vertexCount = vertexCount;
        this.edgeCount = 0;
        this.adjacencyMatrix = new int[vertexCount][vertexCount];
    }

    /**
     * Adds an undirected edge between two vertices.
     *
     * @param source starting vertex
     * @param destination ending vertex
     */
    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1;
        edgeCount++;
    }

    /**
     * Prints adjacency matrix.
     */
    public void printGraph() {
        Arrays.stream(adjacencyMatrix)
              .forEach(row -> System.out.println(Arrays.toString(row)));
    }

    /**
     * Performs Breadth-First Search (BFS) traversal.
     *
     * BFS explores neighbors level by level.
     *
     * @param startVertex starting vertex for traversal
     * @return list of vertices in BFS order
     */
    public List<Integer> bfs(int startVertex) {

        List<Integer> traversalOrder = new ArrayList<>();
        boolean[] visited = new boolean[vertexCount];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(startVertex);
        visited[startVertex] = true;

        while (!queue.isEmpty()) {

            int currentVertex = queue.poll();
            traversalOrder.add(currentVertex);

            // Visit all adjacent vertices
            for (int neighbor = 0; neighbor < vertexCount; neighbor++) {
                if (adjacencyMatrix[currentVertex][neighbor] == 1 && !visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return traversalOrder;
    }

    /**
     * Performs Depth-First Search (DFS) traversal (Iterative).
     *
     * DFS explores as deep as possible before backtracking.
     *
     * @param startVertex starting vertex for traversal
     * @rturn list of vertices in DFS order
     */
    public List<Integer> dfs(int startVertex) {

        List<Integer> traversalOrder = new ArrayList<>();
        boolean[] visited = new boolean[vertexCount];
        Stack<Integer> stack = new Stack<>();

        stack.push(startVertex);
        visited[startVertex] = true;

        while (!stack.isEmpty()) {

            int currentVertex = stack.pop();
            traversalOrder.add(currentVertex);

            // Traverse in reverse order to maintain natural order
            for (int neighbor = vertexCount - 1; neighbor >= 0; neighbor--) {
                if (adjacencyMatrix[currentVertex][neighbor] == 1 && !visited[neighbor]) {
                    stack.push(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return traversalOrder;
    }
    
    public int getVertexCount() {
    	return vertexCount;
    }
    
    public int getEdgeCount() {
    	return edgeCount;
    }

}
