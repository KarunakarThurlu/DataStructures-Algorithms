package graph.adjmatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class AdjMatrixGraph {
	
	// To store vertex count
	private int V;
	
	// To store Edge count
	private int E;
	
	// To Store Edges 
	private int[][] adjMatrix;
	
	public AdjMatrixGraph(int V, int E) {
		this.V = V;
		this.E = E;
		adjMatrix=new int[V][V];
	}

	public void addEdge(int from,int to) {
		adjMatrix[from][to]=1;
		adjMatrix[to][from]=1;
		E++;
	}

	public void printGraph() {
		Arrays.stream(adjMatrix).forEach(m -> System.out.println(Arrays.toString(m)));
	}
	
	/**
	 * Problem : Breath First Search(BFS) Traversal in AdjMatrix
	 * @param startVertex
	 * @return BFS Search List
	 */
	public List<Integer> adjMatrixBFS(int startVertex) {
		List<Integer> bfsList = new ArrayList<>();
		boolean[] track = new boolean[V];
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(startVertex);
		track[startVertex] = true;

		while (!queue.isEmpty()) {
			Integer poll = queue.poll();
			bfsList.add(poll);
			for (int i = 0; i < V; i++) {
				if (adjMatrix[poll][i] == 1 && !track[i] ) {
					queue.offer(i);
					track[i] = true;
				}
			}
		}
		return bfsList;
	}
	
	/**
	 * Problem : Depth First Search(DFS) Traversal in AdjMatrix
	 * @param startVertex
	 * @return DFS Search List
	 */
	public List<Integer> adjMatrixDFS(int startVertex) {
		List<Integer> dfsList = new ArrayList<>();
		boolean[] track = new boolean[V];
		Stack<Integer> stack = new Stack<>();

		stack.push(startVertex);
		track[startVertex] = true;

		while (!stack.isEmpty()) {
			Integer pop = stack.pop();
			dfsList.add(pop);
			for (int i = V-1; i >=0; i--) {
				if (adjMatrix[pop][i] == 1 && !track[i]) {
					stack.push(i);
					track[i] = true;
				}
			}
		}
		return dfsList;
	}


	public static void main(String... GraphWithAdjMatrix) {
		AdjMatrixGraph amg = new AdjMatrixGraph(4,4);
        amg.addEdge(0, 1);
        amg.addEdge(1, 2);
        amg.addEdge(2, 3);
        amg.addEdge(3, 0);
        amg.addEdge(0, 2);
        amg.addEdge(3, 1);
		
		
		List<Integer> adjMatrixDFS = amg.adjMatrixDFS(2);
		System.out.println(adjMatrixDFS);
		
		List<Integer> adjMatrixBFS = amg.adjMatrixBFS(2);
		System.out.println(adjMatrixBFS);
	}
	
}
