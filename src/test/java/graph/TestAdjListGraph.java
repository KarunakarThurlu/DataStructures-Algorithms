package graph;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestAdjListGraph {

    static Stream<Arguments> bfsTestData() {

        AdjListGraph graph = new AdjListGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(0, 4);

        return Stream.of(
                Arguments.of(graph, 0, List.of(0, 1, 4, 2, 3)),
                Arguments.of(graph, 1, List.of(1, 0, 2, 4, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("bfsTestData")
    @DisplayName("Test BFS Traversal of adjlistgraph")
    void testBFS(AdjListGraph graph, int start, List<Integer> expected) {
        assertEquals(expected, graph.bfs(start));
    }

    static Stream<Arguments> dfsTestData() {

        AdjListGraph graph = new AdjListGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(0, 4);

        return Stream.of(
                Arguments.of(graph, 0, List.of(0, 1, 2, 3, 4))
        );
    }

    @ParameterizedTest
    @MethodSource("dfsTestData")
    @DisplayName("Test DFS Traversal of adjlistgraph")
    void testDFS(AdjListGraph graph, int start, List<Integer> expected) {
        assertEquals(expected, graph.dfs(start));
    }
}
