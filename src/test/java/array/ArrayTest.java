package array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ArrayTest {

	@ParameterizedTest
	@MethodSource("provideTwoSumTestCases")
	@DisplayName("Two Sum Problem Test Cases")
	void testTwo(int[] input, int target, int[] expected) {
		int[] actual = Array.twoSum(input, target);
		assertArrayEquals(expected, actual, "Expected and Actual Arrays should be equal");
	}

	private static Stream<Arguments> provideTwoSumTestCases() {
		return Stream.of(
				Arguments.of(new int[] { 2, 7, 11, 15 }, 9, new int[] { 0, 1 }),
				Arguments.of(new int[] { 3, 2, 4, 6 }, 6, new int[] { 1, 2 }),
				Arguments.of(new int[] { -3, 4, 3, 90 }, 0, new int[] { 0, 2 }),
				Arguments.of(new int[] { 3, 3 }, 6, new int[] { 0, 1 }),
				Arguments.of(new int[] { 1, 2, 3 }, 7, new int[] { -1, -1 })
			);
	}
	
	@ParameterizedTest
	@MethodSource("provideTwoSumIITestCases")
	@DisplayName("Two Sum II Problem Test Cases")
	void testTwoII(int[] input, int target, int[] expected) {
		int[] actual = Array.twoSumII(input, target);
		assertArrayEquals(expected, actual, "Expected and Actual Arrays should be equal");
	}

	private static Stream<Arguments> provideTwoSumIITestCases() {
		return Stream.of(
				Arguments.of(new int[] { 2, 7, 11, 15 }, 13, new int[] { 0, 2 }),
				Arguments.of(new int[] { 3, 6, 9, 16 }, 22, new int[] { 1, 3 }),
				Arguments.of(new int[] { -3, -1, 3, 90 }, 0, new int[] { 0, 2 }),
				Arguments.of(new int[] { 3, 3, 3, 3, 3 }, 6, new int[] { 0, 4 }),
				Arguments.of(new int[] { 0, 2, 7 }, 7, new int[] { 0, 2 }),
				Arguments.of(new int[] { 0, 2, 6 }, 7, new int[] { -1, -1 }),
				Arguments.of(new int[] { 7 }, 7, new int[] { -1, -1 })
			);
	}
	
	@ParameterizedTest
	@MethodSource("provideMergeSortedArraysCases")
	@DisplayName("Merge Sorted Arrays Test Cases")
	void testMergeSortedArrays(int[] arrayOne, int[] arrayTwo, int[] expected) {
		int[] actual = Array.mergeSortedArrays(arrayOne, arrayTwo);
		assertArrayEquals(expected, actual, "Expected and Actual Arrays should be equal");
	}

	private static Stream<Arguments> provideMergeSortedArraysCases() {
		return Stream.of(
				Arguments.of(new int[] { 2, 7, 11},new int[] {3,5}, new int[] { 2, 3, 5, 7, 11}),
				Arguments.of(new int[] { 3, 6}, new int[] {-3}, new int[] { -3, 3, 6 }),
				Arguments.of(new int[] { -3, -1 },new int[]{ 0 }, new int[] { -3, -1, 0}),
				Arguments.of(new int[] { 3, 3, 3}, new int[] {3}, new int[] { 3, 3, 3, 3}),
				Arguments.of(new int[] { 0, 2, 7 }, new int[] {}, new int[] { 0, 2, 7 }),
				Arguments.of(new int[] { 7 }, new int[] {8}, new int[] { 7, 8}),
				Arguments.of(new int[] { }, new int[] {}, new int[] { })
			);
	}
}
