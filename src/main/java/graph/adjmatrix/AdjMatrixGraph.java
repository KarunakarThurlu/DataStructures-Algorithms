package graph.adjmatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

		queue.add(startVertex);
		track[startVertex] = true;

		while (!queue.isEmpty()) {
			Integer poll = queue.poll();
			bfsList.add(poll);
			for (int i = 0; i < V; i++) {
				if (adjMatrix[poll][i] == 1 && track[i] == false) {
					queue.add(i);
					track[i] = true;
				}
			}
		}
		return bfsList;
	}


	public static void main(String... GraphWithAdjMatrix) {
		AdjMatrixGraph amg = new AdjMatrixGraph(4,6);
		amg.addEdge(0, 1);
		amg.addEdge(1, 2);
		amg.addEdge(2, 3);
		amg.addEdge(3, 0);
		amg.addEdge(0, 2);
		amg.addEdge(3, 1);
		
		amg.printGraph();
		
		List<Integer> adjMatrixBFS = amg.adjMatrixBFS(2);
		System.out.println(adjMatrixBFS);
	}
	
	//1. Create Graph
	
	//2. DFS Search
	
	//3. BFS Search
	
}
