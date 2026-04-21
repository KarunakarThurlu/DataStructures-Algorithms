package graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class TestGraphProblems {
	
	static Stream<Object[]> testData() {
		return Stream.of(
				new Object[] { new int[][] { { 1, 1, 0, 0 }, { 1, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } }, 3 },
				new Object[] { new int[][] { { 1, 1, 1 }, { 0, 1, 0 }, { 1, 1, 1 } }, 1 },
				new Object[] { new int[][] { { 0, 0, 0 }, { 0, 0, 0 } }, 0 });
	}

    @ParameterizedTest
    @MethodSource("testData")
    void shouldCountIslands(int[][] grid, int expected) {
        assertEquals(expected, GraphProblems.numberOfIslands(grid));
    }
}
