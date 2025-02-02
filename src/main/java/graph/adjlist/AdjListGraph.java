package graph.adjlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class AdjListGraph {
    private LinkedList<Integer>[] adjList;
    private int V;

    public AdjListGraph(int V) {
        this.V = V;
        this.adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int from, int to) {
        adjList[from].add(to);
        adjList[to].add(from); // If undirected graph
    }

    public List<Integer> bfs(int startingPoint) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] track = new boolean[V]; // Use primitive boolean array

        queue.offer(startingPoint);
        track[startingPoint] = true;

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            list.add(poll);

            for (int neighbor : adjList[poll]) { // ✅ Only iterate over connected neighbors
                if (!track[neighbor]) {
                    queue.offer(neighbor);
                    track[neighbor] = true;
                }
            }
        }
        return list;
    }

    public List<Integer> dfs(int startingPoint) {
        List<Integer> list = new ArrayList<>();
        boolean[] track = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        stack.push(startingPoint);
        track[startingPoint] = true;

        while (!stack.isEmpty()) {
            int pop = stack.pop();
            list.add(pop);

            for (int neighbor : adjList[pop]) { // ✅ Only iterate over connected neighbors
                if (!track[neighbor]) {
                    stack.push(neighbor);
                    track[neighbor] = true;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        AdjListGraph graph = new AdjListGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(0, 4);

        System.out.println("BFS Traversal: " + graph.bfs(0));
        System.out.println("DFS Traversal: " + graph.dfs(0));
    }
}
