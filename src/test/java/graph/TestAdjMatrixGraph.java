package graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestAdjMatrixGraph {
	
    /**
     * Provides test cases for BFS traversal.
     */
    static Stream<Arguments> bfsTestData() {

        AdjMatrixGraph graph = new AdjMatrixGraph(4);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        graph.addEdge(0, 2);
        graph.addEdge(3, 1);

        return Stream.of(
                Arguments.of(graph, 0, List.of(0, 1, 2, 3)),
                Arguments.of(graph, 1, List.of(1, 0, 2, 3)),
                Arguments.of(graph, 2, List.of(2, 0, 1, 3)),
                Arguments.of(graph, 3, List.of(3, 0, 1, 2))
        );
    }

    /**
     * Parameterized test for BFS traversal.
     */
    @ParameterizedTest
    @MethodSource("bfsTestData")
    void testBFS(AdjMatrixGraph graph, int startVertex, List<Integer> expected) {
        assertEquals(expected, graph.bfs(startVertex));
    }

    /**
     * Provides test cases for DFS traversal.
     */
    static Stream<Arguments> dfsTestData() {

        AdjMatrixGraph graph = new AdjMatrixGraph(4);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        graph.addEdge(0, 2);
        graph.addEdge(3, 1);

        return Stream.of(
                Arguments.of(graph, 0, List.of(0, 1, 2, 3)),
                Arguments.of(graph, 1, List.of(1, 0, 2, 3)),
                Arguments.of(graph, 2, List.of(2, 0, 1, 3)),
                Arguments.of(graph, 3, List.of(3, 0, 1, 2))
        );
    }

    /**
     * Parameterized test for DFS traversal.
     */
    @ParameterizedTest
    @MethodSource("dfsTestData")
    void testDFS(AdjMatrixGraph graph, int startVertex, List<Integer> expected) {
        assertEquals(expected, graph.dfs(startVertex));
    }
}
